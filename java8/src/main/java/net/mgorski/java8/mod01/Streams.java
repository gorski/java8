package net.mgorski.java8.mod01;

import java.util.Arrays;
import java.util.List;

public class Streams {

    public static void main(String[] args) {

        // filter, map, foreach
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        System.out.println("First present?");
        myList.stream().findFirst().ifPresent(s-> {System.out.println("Yes, of value:"+s);});

        System.out.println("Contains b?");
        myList.stream().sorted().map(s -> { return s.contains("b");}).forEach(System.out::println);

    }
}
