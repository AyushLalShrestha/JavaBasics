package com.als.collections;

import java.util.ArrayList;

class Record{
    String label, value;
    public Record(String label, String value){
        this.label = label;
        this.value = value;
    }
    public String getLabel(){
        return this.label;
    }
    public String getValue(){
        return this.value;
    }
    public boolean equals(Object obj){
        Record other = (Record) obj;
        return value.equalsIgnoreCase(other.value);
    }  
}

public class CollectionInterface{
    public static void run(){
        ArrayList<Record> list = new ArrayList<>();
        Record v1 = new Record("v1", "abc");
        Record v2 = new Record("v2", "abc");
        Record v3 = new Record("v3", "abc");
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.remove(v3); // This will actually remove v1
    }
    public void lamdaFunctions(){
        ArrayList<Record> list = new ArrayList<>();
        Record v1 = new Record("v1", "abc");
        Record v2 = new Record("v2", "ijk");
        Record v3 = new Record("v3", "xyz");
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.forEach(m -> System.out.println(m.getLabel()));
        list.removeIf(m -> m.getValue().equals("abc"));

    }
}

