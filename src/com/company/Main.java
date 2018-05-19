package com.company;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
	Conteiner con = new Conteiner("Hi for all!");
	Class<?> cls = con.getClass();
	if(!cls.isAnnotationPresent(SaveToFile.class)){
	    System.out.println("Error");
	    return;
    }
	SaveToFile saveToFile = cls.getAnnotation(SaveToFile.class);
	String path = saveToFile.path();
	Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            if(m.isAnnotationPresent(Save.class)) {
                m.invoke(con, path);
                break;
            }
        }
    System.out.println("File is ready))");
    }

}
