package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        String string = null;
        try {
            string = args[0];
        } catch (Exception ignore) {
        }

        if ( string != null && string.matches("^[a-zA-Z0-9]+$")) {
            for (int i = 2; i < 37; i++) {
                try {
                    BigInteger bigInteger = new BigInteger(string, i);
                    System.out.println(String.valueOf(i));
                    break;
                } catch (Exception ignore) {
                }
            }
        } else
            System.out.println("incorrect");
    }
}