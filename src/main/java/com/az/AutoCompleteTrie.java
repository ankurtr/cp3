package com.az;

import java.util.*;
import java.util.stream.IntStream;

public class AutoCompleteTrie {
    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};

        int[] times = new int[]{5, 3, 2, 2};

        AutocompleteSystem(sentences, times);

        char[] ip = new char[5];
        ip[0] = 'i';
        ip[1] = ' ';
        ip[2] = 'a';
        ip[3] = '#';

        IntStream.range(0, 4)
                .forEach(index -> System.out.println(input(ip[index])));
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }

    static TrieNode root;
    static String prefix;


    public static void AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private static void add(String s, int count) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }

    public static List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }

        prefix = prefix + c;
        TrieNode curr = root;
        for (char cc : prefix.toCharArray()) {
            TrieNode next = curr.children.get(cc);
            if (next == null) {
                return new ArrayList<>();
            }
            curr = next;
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
        pq.addAll(curr.counts.entrySet());

        List<String> res = new ArrayList<>();

        int k = 3;
        while (!pq.isEmpty() && k > 0) {
            res.add(pq.poll().getKey());
            k--;
        }
        return res;
    }
}
