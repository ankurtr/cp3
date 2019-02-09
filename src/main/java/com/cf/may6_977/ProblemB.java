package com.cf.may6_977;

import java.util.*;

/**
 * Created by trapaank1 on 06/05/18.
 */
public class ProblemB {
    public static String getSubstring(String s) {
        Map<String, Integer> map = new TreeMap<>();
        char[] elements = s.toCharArray();
        for (int i = 0; i < elements.length - 1; i++) {
            String substring = s.substring(i, i + 2);
            if (map.containsKey(substring)) {
                continue;
            }
            int count = 0;
            for (int j = i; j < elements.length; j++) {
                if ((j + 2 <= elements.length)) {
                    String p = s.substring(j, j + 2);
                    if (substring.equals(p)) {
                        count++;
                    }
                }
            }
            map.put(substring, count);
        }
        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int l = sc.nextInt();
            String s = sc.next();
            System.out.println(getSubstring(s));
        }
    }
}
