package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> longList = new ArrayList<>();

        int[][] massiv = new int[10][String.valueOf(N).length()];

        for (int i = 0; i < massiv.length; i++)
            for (int j = 0; j < massiv[0].length; j++)
                massiv[i][j] = (int)Math.pow(i, j + 1);

        long number = 0L;

        while (number <= N)
        {
            char[] buffer = String.valueOf(number).toCharArray();
            long sum = 0;
            for (char symbol : buffer)
            {
                sum += massiv[Integer.parseInt(String.valueOf(symbol))][buffer.length - 1];
            }

            if (sum == number) {
                longList.add(number);
                System.out.println(number);
            }


            number++;
        }

        result = new long[longList.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = longList.get(i);

        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getNumbers(40000000);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " millisecond");
    }
}
