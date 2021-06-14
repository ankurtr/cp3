package com.j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class WayFairBadgeInMezzy {

    public static void main(String... args) {
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
        solution(input);
    }

    private static void solution(String[][] timeSwipes) {
        Map<Integer, Map<String, Set<Integer>>> cardEntries = new HashMap<>();
        Map<String, Set<Set<Integer>>> output = new HashMap<>();
        Arrays.stream(timeSwipes).forEach(timeSwipeEntry -> {
            int time = parse(timeSwipeEntry[1]);
            // for each minute add original entry time in the value for the person map
            IntStream.range(time, time + 61).forEach(minute -> {
                cardEntries.compute(minute, (cardEntryKey, cardEntryValue) -> {
                    cardEntryValue = cardEntryValue == null ? new HashMap<>() : cardEntryValue;
                    cardEntryValue.compute(timeSwipeEntry[0], (person, swipeInTimes) -> {
                        swipeInTimes = swipeInTimes == null ? new HashSet<>() : swipeInTimes;
                        swipeInTimes.add(time);
                        return swipeInTimes;
                    });
                    return cardEntryValue;
                });
            });
        });
        // output processing
        cardEntries.values().forEach(personToInTimeMap -> {
            // for each minute entry pick only cases where person entries is more than 2
            personToInTimeMap.entrySet().stream()
                    .filter(personToInTimeEntry -> personToInTimeEntry.getValue().size() > 2)
                    .forEach(personToInTimeEntry -> {
                        output.compute(personToInTimeEntry.getKey(), (person, inTimeGroup) -> {
                            inTimeGroup = inTimeGroup == null ? new HashSet<>() : inTimeGroup;
                            inTimeGroup.add(personToInTimeEntry.getValue());
                            return inTimeGroup;
                        });
                    });
        });
        //System.out.println(cardEntries);
        System.out.println(output);
    }

    private static int parse(String time) {
        int hh = 0;
        int mm = 0;
        if (time.length() == 4) {
            hh = Integer.parseInt(time.substring(0, 2));
            mm = Integer.parseInt(time.substring(2));
        } else if (time.length() == 3) {
            hh = Integer.parseInt(time.substring(0, 1));
            mm = Integer.parseInt(time.substring(1));
        } else {
            hh = Integer.parseInt(time);
        }
        return hh * 60 + mm;
    }
}