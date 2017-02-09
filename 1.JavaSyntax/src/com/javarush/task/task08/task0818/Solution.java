package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivanov", 1000);
        map.put("Petrov", 300);
        map.put("Sidorov", 800);
        map.put("User1", 1000);
        map.put("User2", 250);
        map.put("User3", 1000);
        map.put("User4", 1000);
        map.put("User5", 100);
        map.put("User6", 1000);
        map.put("User7", 299);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
    }
}