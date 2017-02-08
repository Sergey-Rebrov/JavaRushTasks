package com.javarush.task.task01.task0140;

import java.io.IOException;
import java.util.Scanner;


/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int a;
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        scanner.close();

        System.out.println(a * a);
    }
}