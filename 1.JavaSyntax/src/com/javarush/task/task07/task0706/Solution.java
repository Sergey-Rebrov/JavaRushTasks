package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] massiv = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = Integer.parseInt(reader.readLine());
        }

        int even = 0;
        int odd = 0;

        for (int i = 0; i < massiv.length; i++) {
            if (i % 2 == 0)
                even += massiv[i];
            else
                odd += massiv[i];
        }

        if (even > odd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
