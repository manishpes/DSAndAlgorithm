package com.manish;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIteration {


    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("Manish","Ranjan");
        hashMap.put("Sweety","Ranjan");
        hashMap.put("Test","Ranjan");



        /**
         * Iterate using entry set
         */
        System.out.println("\n1. Using entrySet");
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        for(Map.Entry<String, String> entry : entrySet ){
            System.out.println(entry.getKey() +"  "+ entry.getValue());
        }

        /*
         *Iterate using keyset
         *
         */
        System.out.println("\n2. Using Keyset");
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            System.out.println(key+"  " +  hashMap.get(key));
        }

        /**
         *
         * Using Lamda
         */
        System.out.println("\n3. Using Lambda");
        hashMap.forEach((k, v) -> System.out.println(k+"   "+v));

        /*
         * Iterate using Iterator
         *
         */
        System.out.println("\n4. Using Iterator");
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey() + "  "+  entry.getValue());
        }
    }
}
