package ds.java.multithreading;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableFuture {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            BigInteger.valueOf(scanner.nextLong());
        }
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        FutureTask<Integer> futureTask = executorService.submit();
//        Thread thread = new Thread(futureTask);
//        thread.start();
    }

}
