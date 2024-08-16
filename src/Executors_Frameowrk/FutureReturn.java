package Executors_Frameowrk;

import java.util.concurrent.*;
import java.util.concurrent.Executors;

public class FutureReturn {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> submit = service.submit(() -> 42);
        System.out.println(submit.get());
        if(submit.isDone()){
            System.out.println("Task is completed");
        }
        service.shutdown();
        Callable<String> task = ()->"Hello";
        ExecutorService service2 = Executors.newFixedThreadPool(1);
        Future<String> submit2 = service2.submit(task);
        System.out.println(submit2.get());

        ExecutorService service3 = Executors.newFixedThreadPool(1);
        //if this runs successfully , "abc" will get stored inside submit3(future)
        //gives runnable to return something
        Future<String> submit3 = service3.submit(()-> System.out.println("Hello"),"abc");
        System.out.println(submit3.get());
    }
}
