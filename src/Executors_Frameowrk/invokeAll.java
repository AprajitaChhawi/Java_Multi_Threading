package Executors_Frameowrk;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.Executors;

public class invokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = ()->{
            System.out.println("Task1");
            return 1;
        };
        Callable<Integer> callable2 = ()->{
            System.out.println("Task2");
            return 2;
        };
        Callable<Integer> callable3 = ()->{
            System.out.println("Task3");
            return 3;
        };
        List<Callable<Integer>> list = Arrays.asList(callable1,callable2,callable3);
        List<Future<Integer>> futures = service.invokeAll(list,1,TimeUnit.MILLISECONDS);
        for(Future<Integer> f:futures){
            System.out.println(f.get());
        }
        try {
            Integer futures1 = service.invokeAny(list,1,TimeUnit.MILLISECONDS);
            System.out.println(futures1);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
