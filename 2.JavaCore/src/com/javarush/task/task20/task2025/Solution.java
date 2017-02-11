package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> longList = new ArrayList<>();

        long porog = 10;
        long[] massiv = {0,1,2,3,4,5,6,7,8,9};

        for (long number = 1; number < N; number++) {

            if (number == porog){
                porog *= 10;
                for (int i = 0; i < massiv.length; i++)
                    massiv[i] *= i;
            }

            long sum = 0;
            long tmp = number;

            while (tmp > 0) {
                int x = (int)(tmp % 10);
                sum += massiv[x];
                if (sum > number)
                    break;

                tmp /= 10;
            }

            if (sum == number) {
                longList.add(number);
            }

        }

        result = new long[longList.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = longList.get(i);

        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Integer.MAX_VALUE)));
        long end = System.currentTimeMillis();
        System.out.println(end - start + " millisecond");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");

    }
}
