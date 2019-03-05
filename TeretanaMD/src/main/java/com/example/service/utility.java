package com.example.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



public class utility {

	public static <T> List<Field> getFields(T t) {
         List<Field> fields = new ArrayList<>();
         Class<?> clazz = t.getClass();
        while (clazz != Object.class) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        
        return fields;
    }
    
    /*  Metod dohvata sve metode neke klase ukljucujuci i metode iz nasledjenih klasa ,sve do nivoa Object klase */
    /*
    */
     public static <T> List<Method> getMethode(T t) {
    	 List<Method> meth = new ArrayList<>();
    	 Class<?> clazz = t.getClass();
        while (clazz != Object.class) {
            meth.addAll(Arrays.asList(clazz.getDeclaredMethods()));
            clazz = clazz.getSuperclass();
        }
        
        return meth;
    }

	public static <T, U> void prekopiraj(T iz, U u) {
		
		for (Iterator<Field> iterator = getFields(iz).iterator(); iterator.hasNext();) {
			
			Field polje = iterator.next();
  
	            	try {
	            		boolean acc = polje.isAccessible();
	            		
	            		polje.setAccessible(true);
	            		
						polje.set(u, polje.get(iz)) ;
						
						polje.setAccessible(acc);
						
						
					} catch (IllegalArgumentException | IllegalAccessException e) {
						
						e.printStackTrace();
					}
	            	
	        }

		}
	
	public static void saljiMailClanovimaSaDugovanjima(Date date) {
		
		
	}
	
	
}