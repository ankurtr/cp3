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
}
