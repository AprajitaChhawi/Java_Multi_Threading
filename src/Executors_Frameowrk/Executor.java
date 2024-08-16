package Executors_Frameowrk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> submit1 = executor.submit(() -> 1 + 2);
        Integer i = submit1.get();
        System.out.println(i);
        executor.shutdown();
        Thread.sleep(10);
        System.out.println(executor.isTerminated());
    }
}
