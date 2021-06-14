package com.leetcode.contest;

public class MakeStringSorted {
    public static void main(String[] args) {
        System.out.println(makeStringSorted("cba"));
    }

    private static int makeStringSorted(String s) {
        if (s == null || isSorted(s)) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int operations = 0;
        while (i != -1) {
            char[] c = s.toCharArray();
            i = getI(s);
            j = getJ(s, 1);
            if (i == -1 || j == -1) {
                break;
            }
            if (i - 1 >= 0) {
                char temp = c[i - 1];
                c[i - 1] = c[j];
                c[j] = temp;
            }
            String s2 = reverse(s, i, j);
            operations++;
        }
        return operations;
    }

    private static int getI(String s) {
        char[] chars = s.toCharArray();
        int l = chars.length - 1;
        int i = l;
        while (l-- > 0) {
            if (l - 1 == -1)
                break;
            if (chars[l] < chars[l - 1]) {
                i = l - 1;
                break;
            }
        }
        return i;
    }

    private static int getJ(String s, int i) {
        if (i - 1 < 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int j = i;
        while (true) {
            if (i - 1 >= 0 && j < chars.length - 1 && chars[i - 1] > chars[j]) {
                j++;
                continue;
            } else {
                j--;
                break;
            }
        }
        return j;
    }

    private static String reverse(String s, int i, int j) {
        if (s == null || s.length() < i || s.length() < j) {
            return s;
        }

        char[] chars = s.toCharArray();

        for (; i < (i + (i + j) / 2); i++) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }

    private static boolean isSorted(String s) {
        char[] chars = s.toCharArray();

        int i = chars.length - 1;
        for (; i > 0; i--) {
            if (chars[i] < chars[i - 1])
                break;
        }
        return i == 0;
    }
}
