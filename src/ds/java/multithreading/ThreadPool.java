package ds.java.multithreading;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        threadPool.doSomeThing();
    }

    public void doSomeThing(){
        System.out.println("Creating object");
        GCObject gcObject = new GCObject();
        gcObject = null;
        System.gc();
    }

    class GCObject{
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Bye Bye");
        }
    }

}
