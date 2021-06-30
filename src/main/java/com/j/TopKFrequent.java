package com.j;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        String[] words = new String[7];
        words[0] = "dilraju";
        words[1] = "hi";
        words[2] = "hey";
        words[3] = "hello";
        words[4] = "hi";
        words[5] = "hi";
        words[6] = "hello";

        System.out.println(new TopKFrequent().topKFrequent(words, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new LinkedHashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((n1, n2) -> {
            if (!n1.getValue().equals(n2.getValue())) {
                return n2.getValue() - n1.getValue();
            } else {
                return n1.getKey().compareTo(n2.getKey());
            }

        });


        for (Map.Entry<String, Integer> key : freq.entrySet()) {
            pq.offer(key);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(Objects.requireNonNull(pq.poll()).getKey());
        }
        return result;
    }
}
