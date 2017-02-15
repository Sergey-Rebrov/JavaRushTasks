package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by Sergey on 14.02.2017.
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 1; i <= 9; i++)
            {
                ShareItem shareItem = new ShareItem("ShareItem-" + i, i);
                System.out.format("Элемент ‘%s‘ добавлен", shareItem.getDescription());
                System.out.println();
                queue.offer(shareItem);

                Thread.sleep(100);

                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!");
                    System.out.println();
                }
            }
        }
        catch (InterruptedException ignore)
        {
        }
    }
}
