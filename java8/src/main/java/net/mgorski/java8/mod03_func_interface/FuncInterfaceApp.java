package net.mgorski.java8.mod03_func_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class FuncInterfaceApp {

    public static void main(String[] args) throws InterruptedException {


        // Runnable
        Runnable r = () -> System.out.println("Runnable stuff.");

        new Thread(r).start();
        new Thread(() -> System.out.println("Or even simpler")).start();

        int lucky = 7;
        new Thread(() -> System.out.println("Lucky number is " + lucky)).start();


        // functional interface from API
        BiFunction<Integer, Integer, String> example = (a, b) -> {
            return "Sum of " + a + " and " + b + " is " + (a + b);
        };
        System.out.println(example.apply(1, 2));


        // local variables Java 9
//        Map<String, String> map = Map.ofEntries(Map.entry("a","1"));

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);

        new Thread(() -> {
            map.put("a", 666);

        }).start();


        Thread.sleep(50);

        System.out.println("Value of A in the map is : "+ map.get("a"));

    }


}
