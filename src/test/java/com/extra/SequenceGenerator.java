package com.extra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ankur on 10/10/17.
 */
public class SequenceGenerator {

    private static final List<Character> SYMBOLS;
    private static final int NO_OF_SYMBOLS;
    private static final int OUTPUT_STRING_LENGTH = 3;

    static {
        SYMBOLS = new ArrayList<>();
        for (char c : "ABCDE".toCharArray()) {
            SYMBOLS.add(new Character(c));
        }
        NO_OF_SYMBOLS = SYMBOLS.size();
    }

    private static final int C_INDEX = SYMBOLS.indexOf('C');
    private static final long DECIMAL_OFFSET = (long) ((C_INDEX * Math.pow(NO_OF_SYMBOLS, 2))
            + (C_INDEX * Math.pow(NO_OF_SYMBOLS, 1)) + (C_INDEX * Math.pow(NO_OF_SYMBOLS, 0)));



    private static String nextRef(int index) {
        long valueToConvert = index + DECIMAL_OFFSET;
        /*System.out.println(index + ")=============================================================================");
        System.out.println();
        System.out.println();*/
        String generatedSequence = convertToCustomBase(valueToConvert, OUTPUT_STRING_LENGTH - 1);
        /*System.out.println("int value : " + valueToConvert + ", generatedSequence : " + generatedSequence);
        System.out.println("=============================================================================");
        System.out.println();
        System.out.println();*/
        return generatedSequence;
    }

    private static String convertToCustomBase(long numberToConvert, int maxOutputStringLength) {
        /*System.out.println();
        System.out.println("------------------");
        System.out.println("Number to Convert : " + numberToConvert);
        System.out.println("Max output String length : " + maxOutputStringLength);*/
        long base = (long) Math.pow(NO_OF_SYMBOLS, maxOutputStringLength);
        /*System.out.println("Base : " + base);*/
        int currentCharacterIndex = (int) (numberToConvert / base);
        /*System.out.println("CurrentCharacterIndex(numToConvert / base) : " + currentCharacterIndex);*/
        long remainder = numberToConvert % base;
        /*System.out.println("Remainder(numToConvert % Base) : " + remainder);*/
        if (maxOutputStringLength == 0)
            return "" + SYMBOLS.get(currentCharacterIndex);
        /*System.out.println("------------------");
        System.out.println();*/
        return SYMBOLS.get(currentCharacterIndex) + convertToCustomBase(remainder, maxOutputStringLength - 1);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int i = 0;
        while (i < 31) {
            list.add(nextRef(i++));
        }
        System.out.println(list.size() == 31);
        String a = null;
        String b;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (a == null) {
                a = iterator.next();
            } else {
                b = a;
                a = iterator.next();
                if (b.compareTo(a) < 0) {
                    System.out.println(b);
                    continue;
                } else {
                    break;
                }
            }
        }
        /*String str1 = "BBB";
        String str2 = "BAA";

        System.out.println(str1.compareTo(str2));*/
    }
}
