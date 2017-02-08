package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        int count = 0;
        while (true)
        {
            int a = Integer.parseInt(reader.readLine());
            if (a == -1)
                break;

            number += a;
            count++;
        }

        reader.close();
        System.out.println((double) number / count);
    }
}

