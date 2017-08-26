package manas.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class WordProcessorDriver {
    static ForkJoinPool pool = new ForkJoinPool();
    public static void main(String[] args) {
        WordProcessor processor = new WordProcessor(" my name is anthony jhun jhun wala");

        String output = pool.invoke(processor);

        do
        {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");
            try
            {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        } while ((!processor.isDone()));

        System.out.println(output);
    }
}
