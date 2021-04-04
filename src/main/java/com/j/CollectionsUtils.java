package com.j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtils {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ankur");
        list.add("Anil");
        list.add("Pappa");
        list.add("Mummy");
        list.add("Ankur");
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, "Anil"));
        System.out.println(Collections.binarySearch(list, "Mummy"));

        Collections.shuffle(list);
        System.out.println(list);

        System.out.println(Collections.frequency(list, "Ankur"));

        System.out.println(Collections.reverseOrder());
    }
}
