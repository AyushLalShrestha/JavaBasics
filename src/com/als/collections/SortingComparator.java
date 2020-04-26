package com.als.collections;

import java.util.Comparator;
import java.util.TreeSet;

class Entity {
    String label, value;
    public Entity(String label, String value){
        this.label = label;
        this.value = value;
    }
    public String toString(){return label + " | ";}
    public String getLabel(){
        return this.label;
    }
    public String getValue(){
        return this.value;
    }
}

public class SortingComparator implements Comparator<Entity> {
    public int compare(Entity x, Entity y){
        return x.getLabel().compareToIgnoreCase(y.getLabel());
    }
    public static void run(){
        TreeSet<Entity> tree = new TreeSet<>(new SortingComparator());
        tree.add(new Entity("2222", "ghi"));
        tree.add(new Entity("3333", "abc"));
        tree.add(new Entity("1111", "def"));
        tree.forEach(m -> System.out.println(m));
    }
}

