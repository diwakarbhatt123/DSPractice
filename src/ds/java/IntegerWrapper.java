package ds.java;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.StringJoiner;

public class IntegerWrapper {

    public volatile String constant = "Abc";

    public static void main(String[] args) {
        int a[][] = new int[5][10];
        int a2 = 1;
        String s = "abc";
        Integer a3 = 12;
        System.out.println(void.class);
        System.out.println(int.class);
        System.out.println(a.getClass());

        Integer i1 = 124;
        Integer i2 = new Integer(124);
        System.out.println(i2.equals(i1));

        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append("World");
        stringBuilder.toString().toLowerCase();

        Integer.toString(1);
        String.valueOf(1);
        int i = 1234;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        decimalFormat.format(i);












    }

    public static void main(String s1){
        System.out.println("main with s1 called");
    }

}
