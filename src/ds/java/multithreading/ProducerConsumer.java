package ds.java.multithreading;

public class ProducerConsumer {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.pingPing();
    }

    public void pingPing() {
        Thread t1 = new Thread(() -> {
            synchronized (this) {
//                System.out.println(Thread.currentThread().getName()+ " Started1");
                while (true) {
                try {
                    wait();
                    System.out.println("PING");
                    notify();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (this) {
//                System.out.println(Thread.currentThread().getName() + " Started2");
                System.out.println("PONG");
                while (true) {
                    try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
        });
        t1.start();
        t2.start();
    }
}