package ds.java.multithreading;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });

        thread.start();
        thread.join();

        while (true){
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }

}
