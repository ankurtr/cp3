package com.j;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {

    public static void main(String[] args) {
        /*IntStream.generate(() -> (int) (Math.random() * 5)).takeWhile(n -> n != 3)
                .forEachOrdered(System.out::println);*/

        java.util.stream.Stream.of("a", "b", "c")
                .dropWhile(s -> s.equals("b"))
                .forEach(System.out::println);


        List<Integer> intList = new ArrayList<>();
        IntStream.rangeClosed(1, 10)
                .forEach(intList::add);

        IntSummaryStatistics collect = intList.stream().collect(Collectors.summarizingInt(i -> i));

        System.out.println(collect.getMax());
        System.out.println(collect.getSum());
        System.out.println(collect.getCount());
        System.out.println(collect.getAverage());
        System.out.println(collect.getMin());
    }
}
