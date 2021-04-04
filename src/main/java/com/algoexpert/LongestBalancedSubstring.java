package com.algoexpert;

import java.util.Stack;

public class LongestBalancedSubstring {
    public static void main(String[] args) {
        System.out.println(longestBalancedSubstr2("(())(()("));
        System.out.println(longestBalancedSubstr2("(()()(()"));
    }

    private static int longestBalancedSubstr2(String str) {
        char[] chars = str.toCharArray();
        int ob = 0, cb = 0;
        int maxLen = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(')
                ob++;
            else if (chars[i] == ')')
                cb++;
            if (ob == cb) {
                maxLen = Math.max(maxLen, cb * 2);
            } else if (cb > ob) {
                cb = 0;
                ob = 0;
            }
        }

        ob = 0;
        cb = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ')')
                ob++;
            else if (chars[i] == '(')
                cb++;
            if (ob == cb) {
                maxLen = Math.max(maxLen, cb * 2);
            } else if (cb > ob) {
                cb = 0;
                ob = 0;
            }
        }
        return maxLen;
    }

    private static int longestBalancedSubstr1(String str) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        char[] chars = str.toCharArray();
        int maxLen = 0, currentLen;
        int currentTop;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    currentTop = stack.peek();
                    currentLen = i - currentTop;
                    maxLen = Math.max(currentLen, maxLen);
                }
            }
        }
        return maxLen;
    }
}