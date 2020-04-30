package com.als.generics;

public class Animal<T, T2> {
    private T name;
    private T2 type;

    public Animal(T name, T2 type){
        this.name = name;
        this.type = type;
    }

    public void add(T name, T2 type) {
        this.name = name;
        this.type = type;
    }

    public T getName() {
        return name;
    }

    public static void run(String[] args) {
        Animal<Integer, Integer> animal1 = new Animal<Integer, Integer>(1, 11);
        Animal<String, String> animal2 = new Animal<String, String>("Ayush", "Man");

        //   integerBox.add(new Integer(10));
        //   stringBox.add(new String("Hello World"));
        System.out.println((String)animal2.getName());
        System.out.println(Integer.toString(animal1.getName()));

    }
}
