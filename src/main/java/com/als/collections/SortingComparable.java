package com.als.collections;

import java.util.TreeSet;

class Info implements Comparable<Info> {
    String label, value;
    public Info(String label, String value){
        this.label = label;
        this.value = value;
    }
    public String toString(){return label + " | " + value;}
    public String getLabel(){
        return this.label;
    }
    public String getValue(){
        return this.value;
    }
    public boolean equals(Object obj){
        Info other = (Info) obj;
        return value.equalsIgnoreCase(other.value);
    }
    public int compareTo(Info other){
        return value.compareToIgnoreCase(other.value);
    }
}

public class SortingComparable{
    public static void run(){
        TreeSet<Info> tree = new TreeSet<>();
        tree.add(new Info("1111", "ghi"));
        tree.add(new Info("2222", "abc"));
        tree.add(new Info("3333", "def"));
        tree.forEach(m -> System.out.println(m));
    }
}

