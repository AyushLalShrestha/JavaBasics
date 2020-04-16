package com.als.reflections;


public class TypeAsType {
    public static void main(String[] args){
        // Instantiate a new Object of some class
    }
    void classInfo(Object object) {
        Class<?> theClass = object.getClass();
        System.out.println(class.getSimpleName());

        Class<?> superClass = theClass.getSuperclass();
        System.out.println(superClass.getSimpleName());

        Class<?>[] interfaces = theClass.getInterfaces();
        for(Class<> interface: interfaces){
            System.out.println(interface.getSimpleName());
        }

        int modifiers = theClass.getModifiers();  // int value specifying about the modifier
        // if (Modifier.isFinal(modifiers)) { .... } // isPrivate // isPublic


        // Get info about Fields of a class
        Field[] fields = theClass.getDeclaredFields()
        Field[] superfields = theClass.getFields()
        for (Field field: fields){
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
        // Method m = theClass.getField(signature, int.class, String.class ....) // To get individual method
        // m.invoke(object, int.class, String.class ....)

        
        // Get info about Methods of a class
        theClass.getDeclaredMethods()
        theClass.getMethods()

        // Get info about Constructors of a class
        theClass.getDeclaredConstructors()
        theClass.getConstructors()

    }

}
