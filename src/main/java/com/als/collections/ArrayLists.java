package com.als.collections;

import java.util.ArrayList;

public class ArrayLists{
    public void arrayLists(){
        ArrayList list = new ArrayList();
        list.add("Oranges");
        list.add("Mangoes");
        System.out.println(list.size());

        for(Object o: list){
            System.out.println(o.toString()); // Bad
        }
        String firstElem = (String) list.get(0);
    }

    public void stronglyTypedArrayLists(){
        ArrayList<String> list = new ArrayList();
        list.add("Oranges");
        list.add("Mangoes");
        System.out.println(list.size());

        for(String o: list){
            System.out.println(o); // Good
        }
        String firstElem = list.get(0);
    }

}