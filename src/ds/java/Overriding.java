package ds.java;

public class Overriding {

    /*public void doSomething(Integer i){
        System.out.println("Integer i");
    }*/

    public void doSomething(double i){
        System.out.println("int i");
    }

    public static void main(String[] args) {
        Overriding overriding = new Overriding();
        overriding.doSomething(1);
    }
}
