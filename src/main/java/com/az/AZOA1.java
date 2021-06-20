package com.az;

import java.util.*;

public class AZOA1 {

    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        if (logs == null || logs.size() == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<>();

        logs.forEach(logEntry -> {
            String[] tokens = logEntry.split(" ");
            map.put(tokens[0], map.getOrDefault(tokens[0], 0) + 1);
            if (!tokens[0].equals(tokens[1])) {
                map.put(tokens[1], map.getOrDefault(tokens[1], 0) + 1);
            }
        });

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() >= threshold) {
                result.add(entrySet.getKey());
            }
        }

        result.sort(Comparator.comparingInt(Integer::parseInt));

        return result;
    }
}
