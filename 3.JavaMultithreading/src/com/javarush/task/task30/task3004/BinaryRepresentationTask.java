package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Sergey on 19.02.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{
    private int x;

    public BinaryRepresentationTask(int x)
    {
        this.x = x;
    }

    @Override
    protected String compute()
    {
        int a = x % 2;
        int b = x / 2;

        BinaryRepresentationTask binaryOne = new BinaryRepresentationTask(a);
        binaryOne.fork();
        String result = String.valueOf(a);

        if (b > 0)
        {
            BinaryRepresentationTask binaryTwo = new BinaryRepresentationTask(b);
            binaryTwo.fork();
            return binaryTwo.join() + result;
        }
        else
            return result;
    }
}
