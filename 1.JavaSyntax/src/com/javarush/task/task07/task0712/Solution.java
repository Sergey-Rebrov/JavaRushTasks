package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> stringList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
            stringList.add(reader.readLine());

        String max = "";
        String min = stringList.get(0);

        for (String string : stringList)
        {
            if (string.length() > max.length())
                max = string;
            if (string.length() < min.length())
                min = string;
        }

        int a = stringList.indexOf(max);
        int b = stringList.indexOf(min);

        if (a < b)
            System.out.println(max);
        else
            System.out.println(min);

    }
}
