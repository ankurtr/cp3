package com.az;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class top1 {
    public static void main(String[] args) {
        String[] tests = {"test1a", "test2", "test1b", "test1c", "test3"};
        String[] results = {"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"};

        System.out.println(new top1().solution(tests, results));
    }


    public int solution(String[] T, String[] R) {
        // write your code in Java SE 8
        Map<String, Boolean> tests = new HashMap<>();
        String str = null;

        for (int i = 0; i < T.length; i++) {
            str = T[i];
            int index = getSearchIndex(T[i]);
            if (index != 0) {
                str = T[i].substring(0, index + 1);
                if (tests.get(str) == Boolean.TRUE) {
                    if (!R[i].equals("OK")) {
                        tests.put(str, Boolean.FALSE);
                        continue;
                    }
                }
            }
            if(tests.containsKey(str)) {
                continue;
            }
            if (R[i].equals("OK")) {
                tests.put(str, Boolean.TRUE);
            } else {
                tests.put(str, Boolean.FALSE);
            }
        }

        int score = 1;
        for (Map.Entry<String, Boolean> entrySet : tests.entrySet()) {
            if (entrySet.getValue() == Boolean.TRUE) {
                score += 100;
            }
        }

        return score / tests.size();
    }

    private int getSearchIndex(String str) {
        Pattern firstDig = Pattern.compile("\\d[a-zA-Z]+");
        Matcher matcher = firstDig.matcher(str);
        int idx = 0;
        if (matcher.find()) {
            idx = matcher.start();
        }
        return idx;
    }
}
