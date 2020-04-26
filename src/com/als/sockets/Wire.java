package com.als.sockets;

import org.apache.log4j.Logger;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

import java.util.ArrayList;
import java.util.List;

public class Wire {

    protected static final long DEFAULT_QUEUE_SIZE = 10000;

    protected static final Logger logger = Logger.getLogger(Wire.class);

    protected final Socket socket;

    protected Context context;

    protected boolean newContext = false;

    public static Wire createReceiverWire(String socketInfo, Context context, String identifier) {
        return new Wire(socketInfo, context, identifier);
    }

    public Wire(String socketInfo) {
        this(socketInfo, ZMQ.context(1));
        newContext = true;
    }

    public Wire(String socketInfo, String identifier) {
        this(socketInfo, ZMQ.context(1), identifier);
        newContext = true;
    }

    public Wire(String socketInfo, Context context) {
        this(socketInfo, context, DEFAULT_QUEUE_SIZE);
    }

    public Wire(String socketInfo, Context context, String identifier) {
        this(socketInfo, context, DEFAULT_QUEUE_SIZE, identifier);
    }

    public Wire(String socketInfo, Context context, long queueSize, String identifier) {
        this(socketInfo, context, queueSize);
        socket.setIdentity(identifier.getBytes());
    }

    public Wire(String socketInfo, Context zmqContext, long queueSize) {
        this.socketInfo = socketInfo;
        String[] typeMethodAddr = socketInfo.split(":", 3);

        if (typeMethodAddr.length != 3) {
            throw new RuntimeException("Bad socket info \"" + socketInfo + "\"");
        }

        String type = typeMethodAddr[0];
        String method = typeMethodAddr[1];
        String address = typeMethodAddr[2];
        int socketType;

        if (type.equals("PUSH")) {
            socketType = ZMQ.PUSH;
        } else if (type.equals("PULL")) {
            socketType = ZMQ.PULL;
        } else if (type.equals("PUB")) {
            socketType = ZMQ.PUB;
        } else if (type.equals("SUB")) {
            socketType = ZMQ.SUB;
        } else if (type.equals("REQ")) {
            socketType = ZMQ.REQ;
        } else if (type.equals("REP")) {
            socketType = ZMQ.REP;
        } else if (type.equals("XREQ") || type.equals("DEALER")) {
            socketType = ZMQ.DEALER;
        } else if (type.equals("XREP") || type.equals("ROUTER")) {
            socketType = ZMQ.ROUTER;
        } else {
            throw new RuntimeException("Bad socket type \"" + type + "\"");
        }

        if (zmqContext == null) {
            zmqContext = ZMQ.context(1);
            newContext = true;
        }

        context = zmqContext;
        socket = context.socket(socketType);

        // this subscribes for all
        // might be improved to subscribe for all or specific only
        if (socketType == ZMQ.SUB) {
            socket.subscribe("".getBytes());
        }

        socket.setRcvHWM(queueSize);
        socket.setSndHWM(queueSize);


        if (method.equals("bind")) {
            socket.bind(address);
        } else if (method.equals("connect")) {
            socket.connect(address);
        } else {
            throw new RuntimeException("Bad method \"" + method + "\"");
        }
    }

    /**
     * @param message
     */
    public boolean send(byte[] message) {
        if (!socket.send(message, 0)) {
            throw new RuntimeException("Unable to send the message: " + message);
        }

        if (benchmarker != null) {
            benchmarker.stopSend();
        }
        return true;
    }

    /**
     * @param message
     * @return
     */
    public boolean nonBlockingSend(byte[] message) {
        if (!socket.send(message, ZMQ.NOBLOCK)) {
            throw new RuntimeException("Unable to send the message: " + message);
        }
        return true;
    }

    /**
     * @return
     */
    public byte[] recv() {
        byte[] msg = socket.recv(0);
        return msg;
    }

    public void sendMultipart(byte[]... messages) {
        for (int i = 0; i < messages.length; i++) {
            if (!socket.send(messages[i], (i < (messages.length - 1)) ? ZMQ.SNDMORE : 0)) {
                throw new RuntimeException("Unable to send the message: message = " + messages[i]);
            }
        }
    }

    public void sendMultipart(List<byte[]> messages) {
        int size = messages.size();
        int less = size - 1;
        for (int i = 0; i < size; i++) {
            if (!socket.send(messages.get(i), i < less ? ZMQ.SNDMORE : 0)) {
                throw new RuntimeException("Unable to send the message: ");
            }
        }
    }

    public List<byte[]> recvMultipart() {
        List<byte[]> messages = new ArrayList<byte[]>();
        messages.add(socket.recv(0));
        while (socket.hasReceiveMore()) {
            messages.add(socket.recv(0));
        }
        return messages;
    }

    public Socket getSocket() {
        return socket;
    }

    public Context getZMQContext() {
        return context;
    }

    public void close() {
        socket.close();
        if (newContext) {
            context.term();
        }
    }


    public static void run(String[] args) {
        Context context = ZMQ.context(0);
        Wire requester = new Wire("XREQ:connect:ipc:///tmp/repo1.sock", context);
        Wire replier = new Wire("XREP:bind:ipc:///tmp/repo1.sock", context);

        requester.send(StringUtil.toUtf8("hi"));
        List<byte[]> query = replier.recvMultipart();
        System.out.println("query: " + StringUtil.fromUtf8(query.get(1)));

        replier.sendMultipart(query.get(0), query.get(1));
        byte[] response = requester.recv();
        System.out.println("response: " + StringUtil.fromUtf8(response));

        Wire pusher = new Wire("PUSH:connect:ipc:///tmp/repo2.sock", context);
        Wire puller = new Wire("PULL:bind:ipc:///tmp/repo2.sock", context);

        int i = 0;
        while (i < 100000) {
            i += 1;
            pusher.send(StringUtil.toUtf8("hi"));
            System.out.println(StringUtil.fromUtf8(puller.recv()));

        }

        requester.close();
        replier.close();
        pusher.close();
        puller.close();
        context.term();
    }
}