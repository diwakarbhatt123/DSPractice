package ds.java;

public interface TestInterface {
    default void doSomething(){
        System.out.println("Test Interface Do something");
    }
}
