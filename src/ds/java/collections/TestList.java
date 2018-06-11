package ds.java.collections;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class TestList<T> {

    public static void main(String[] args) {
//        List<Integer> integers = new ArrayList<>(1);
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//        Iterator<Integer> integerIterator = integers.iterator();
//        while (integerIterator.hasNext()){
//            System.out.println(integerIterator.next());
//            integerIterator.remove();
//        }

//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(null);
//        list.remove(5);
//
//        AtomicInteger atomicInteger = new AtomicInteger(21);
//        atomicInteger.getAndIncrement();

        Map<String,Integer> map = new LinkedHashMap<>();
        map.keySet().forEach(System.out::println);
        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        map.put("Three",4);
//        map.put(null,5);
        map.put("Five", null);
        map.get("Three");
        map.toString();

//        Semaphore

    }


}
