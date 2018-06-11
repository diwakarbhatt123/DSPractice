package ds.java.multithreading;

public class DataInconsistancy {

    public static void main(String[] args) {
        Adder adder = new Adder();
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (adder) {
                    System.out.println("Thread 1 added " + adder.add());
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (adder) {
                    System.out.println("Thread 2 added " + adder.add());
                }
            }
        });
        t1.start();
        t2.start();
    }

    static class Adder {
        private Integer i = 0;

        public Integer add() {
            return i += 1;
        }
    }

}
