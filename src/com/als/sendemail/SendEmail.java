package com.als.sendemail;
// File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

    public static void run(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "ayush.lal.shrestha@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "artifice.tundra@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

      // Setup mail server 
        //properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.host", "smtp.wlink.com.np");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Email Sent from Java: Test");

            // Now set the actual message
            message.setText("This is a test to send a message from a java program !!");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
