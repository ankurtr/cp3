package com.az;

import java.util.*;

public class CharactGroup {
    public static void main(String[] args) {
        List<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('b');
        chars.add('a');
        chars.add('b');
        chars.add('c');
        chars.add('b');
        chars.add('a');
        chars.add('c');
        chars.add('a');
        chars.add('d');
        chars.add('e');
        chars.add('f');
        chars.add('e');
        chars.add('g');
        chars.add('d');
        chars.add('e');
        chars.add('h');
        chars.add('i');
        chars.add('j');
        chars.add('h');
        chars.add('k');
        chars.add('l');
        chars.add('i');
        chars.add('j');
        System.out.println(new CharactGroup().lengthEachScene(chars));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> lengthEachScene(List<Character> inputList) {
        int[] charFreq = new int[256];

        inputList.forEach(character -> charFreq[character]++);

        Set<Character> charSet = new HashSet<>();
        ArrayList<Integer> counters = new ArrayList<>();
        int count = 0;
        //a-4, b-3, c-2 -  //9, 0
        //ababcbacadefegdehijhklij
        for (Character character : inputList) {
            if (!charSet.contains(character)) {
                charSet.add(character);
            }
            charFreq[character]--;
            count++;
            if (charFreq[character] == 0) {
                charSet.remove(character);
                if (charSet.isEmpty()) {
                    counters.add(count);
                    count = 0;
                }
            }
        }
        return counters;
    }
    // METHOD SIGNATURE ENDS


    //ababcbacadefegdehijhklij
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
