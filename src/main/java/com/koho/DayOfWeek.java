package com.koho;

import java.util.HashMap;
import java.util.Map;

public class DayOfWeek {

    private static final HashMap<Integer, String> DAYS_OF_WEEK = new HashMap<>();

    static {
        DAYS_OF_WEEK.put(1, "Mon");
        DAYS_OF_WEEK.put(2, "Tue");
        DAYS_OF_WEEK.put(3, "Wed");
        DAYS_OF_WEEK.put(4, "Thu");
        DAYS_OF_WEEK.put(5, "Fri");
        DAYS_OF_WEEK.put(6, "Sat");
        DAYS_OF_WEEK.put(7, "Sun");
    }

    public static void main(String[] args) {
        System.out.println(solution("Wed", 2));
        System.out.println(solution("Sat", 23));
    }

    public static String solution(String s, int K) {
        if (s == null || s.equals("")) {
            return null;
        }

        if (K == 0) {
            return s;
        } else {
            for (Map.Entry<Integer, String> entrySet : DAYS_OF_WEEK.entrySet()) {
                if (entrySet.getValue().equals(s)) {
                    int searchIndex = (entrySet.getKey() + K) % DAYS_OF_WEEK.size();
                    return DAYS_OF_WEEK.get(searchIndex);
                }
            }
        }
        return null;
    }
}
