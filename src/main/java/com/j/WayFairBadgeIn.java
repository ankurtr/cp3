package com.j;

import java.util.*;

public class WayFairBadgeIn {

    public static void main(String[] args) {
        String[][] input = {
                {"Paul", "1355"},
                {"Paul", "1405"},
                {"Paul", "1315"},
                {"Jennifer", "1910"},
                {"John", "835"},
                {"John", "830"},
                {"John", "1615"},
                {"John", "1640"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"John", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"John", "1630"},
                {"Jennifer", "5"}
        };
        System.out.println(findUsersWithMaxBadgeIn(input));
    }

    private static Map<String, List<Integer>> findUsersWithMaxBadgeIn(String[][] input) {
        Map<String, List<Integer>> result = new HashMap<>();
        Map<String, List<Integer>> processed = new HashMap<>();

        Arrays.stream(input)
                .forEach(item -> processed.computeIfAbsent(item[0], k -> new ArrayList<>()).add(Integer.parseInt(item[1])));

        processed.forEach((key, value) -> {
            if (value.size() > 2) {
                Collections.sort(value);
                int start = 0;
                int end = 1;
                while (end < value.size()) {
                    int endMins = getMinutes(value.get(end));
                    int startMins = getMinutes(value.get(start));
                    boolean isInHour = (endMins - startMins) <= 60;
                    if (isInHour) {
                        end++;
                    } else if ((end - start) >= 3) {
                        result.put(key, value.subList(start, end));
                        break;
                    } else {
                        start++;
                    }
                }
                if (!result.containsKey(key) && (end - start) >= 3) {
                    result.put(key, value.subList(start, end));
                }
            }
        });

        return result;
    }

    private static int getMinutes(Integer t) {
        String time = String.valueOf(t);
        if (time.length() <= 2) {
            return Integer.parseInt(time) * 60;
        } else {
            if (time.length() == 3) {
                time = "0" + time;
            }
            String mins = time.substring(2);
            String hrs = time.substring(0, 2);

            return Integer.parseInt(hrs) * 60 + Integer.parseInt(mins);
        }
    }
}
