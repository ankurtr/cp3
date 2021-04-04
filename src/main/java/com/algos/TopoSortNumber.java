package com.algos;

import java.util.*;

public class TopoSortNumber {

    public static void main(String[] args) {
        System.out.println(getString(new String[]{"P>E", "E>R", "R>U"}));
        System.out.println(getString(new String[]{"I>N", "A>I", "P>A", "S>P"}));
    }

    private static String getString(String[] conditions) {
        Map<String, String> map = new LinkedHashMap<>();

        //"P>E","R>U","E>R" -> P,E
        Arrays.stream(conditions).forEach(condition -> {
            String[] strs = condition.split(">");
            map.put(strs[0], strs[1]);
        });

        Stack<String> stack = new Stack<>();
        String str = conditions[0];
        stack.push(str.split(">")[0]);
        LinkedList<String> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            String p = stack.pop();
            if (p == null) {
                break;
            }
            String f = map.get(p);
            result.add(p);
            stack.push(f);
        }
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            r.append(result.get(i));
        }
        return r.toString();
    }
}
