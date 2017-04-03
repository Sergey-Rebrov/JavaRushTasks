package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String upSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String downSymbols = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        for (int i = 0; i < 8; i++)
        {
            if (i % 3 == 0)
                baos.write((int)numbers.charAt((int) Math.floor(Math.random() * numbers.length())));
            else if (i % 2 == 0)
                baos.write((int)downSymbols.charAt((int) Math.floor(Math.random() * downSymbols.length())));
            else
                baos.write((int)upSymbols.charAt((int) Math.floor(Math.random() * upSymbols.length())));
        }
        return baos;
    }
}