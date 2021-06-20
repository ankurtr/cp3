package com.j;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};

        Arrays.sort(arr);

        IntStream.range(0, arr.length)
                .forEach(index -> System.out.println(arr[index]));

        /*List<String> arr = new ArrayList<>();
        arr.add("Hi");
        arr.add("Hello");
        arr.add("How");

        System.out.println(String.join("_", arr));*/
    }
}
