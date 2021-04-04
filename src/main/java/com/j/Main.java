package com.j;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("Hi");
        arr.add("Hello");
        arr.add("How");

        System.out.println(String.join("_", arr));
    }
}
