package tutorials.multithreading.ForkJoinFramework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFramework {
    static long numOperations = 100;
    static int numOfThr = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        long currentMil = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(numOfThr);
        System.out.println(pool.invoke(new MyFork(0, numOperations)));
        long currentMil1 = System.currentTimeMillis();
        System.out.println(currentMil);
        System.out.println(currentMil1);

    }

    static class MyFork extends RecursiveTask<Long> {
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;

        }

        @Override
        protected Long compute() {
            if ((to - from) <= numOfThr) {
                long l = 0;
                for (long i = from; i < to; i++) {
                    l += i;
                }
                return l;
            } else {
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondValue = secondHalf.compute();
                return secondHalf.join() + secondValue;
            }
        }
    }
}
