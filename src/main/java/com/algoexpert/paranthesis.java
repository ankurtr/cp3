package com.algoexpert;

import java.util.Stack;

public class paranthesis {
    public static void main(String[] args) {
        //System.out.println(balancedBrackets("([])(){}(())()()"));
        System.out.println(balancedBrackets("[((([])([]){}){}){}([])[]((())"));
    }

    public static boolean balancedBrackets(String str) {
        Stack<Character> chars = new Stack<>();
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '[':
                case '{':
                case '(':
                    chars.push(arr[i]);
                    break;
                case ']':
                case '}':
                case ')':
                    char x = chars.pop();
                    if ((arr[i] == ']' && x == '[') || (arr[i] == '}' && x == '{') || (arr[i] == ')' && x == '('))
                        break;
                    else {
                        return false;
                    }
            }
        }

        return chars.isEmpty();
    }
}
