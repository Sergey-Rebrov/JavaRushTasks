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

        long[][] massiv = new long[10][String.valueOf(N).length()];

        for (int i = 0; i < massiv.length; i++)
            for (int j = 0; j < massiv[0].length; j++) {
                long tmp = i;
                for (int k = 0; k < j; k++)
                    tmp = tmp * i;
                massiv[i][j] = tmp;
            }

        long number = 1L;

        while (number < N) {

            long sum = 0;

            long num = number;
            int degree = 0;
            while (num != 0) {
                num = num / 10;
                degree++;
            }

            boolean flag = true;
            int tmp1 = (int) (number / 10);
            int tmp2 = (int) (number % 10);

            while (flag) {
                if (tmp1 == 0)
                    flag = false;

                if (tmp2 != 0)
                    sum += massiv[tmp2][degree - 1];

                tmp2 = tmp1 % 10;
                tmp1 = tmp1 / 10;
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

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        getNumbers(Integer.MAX_VALUE);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " millisecond");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");

    }
}
