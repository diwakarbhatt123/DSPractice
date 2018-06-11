package ds.java;

public interface TestTooInterface {
    default void doSomething(){
        System.out.println("TestToo something");
    }
}
