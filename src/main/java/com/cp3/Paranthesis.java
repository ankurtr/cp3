package com.cp3;

import java.util.*;

/**
 * Created by ankur on 25/3/17.
 */
public class Paranthesis {

    static Set<Character> open_syms = new HashSet<Character>();
    static Set<Character> closed_syms = new HashSet<Character>();
    static Map<Character, Character> pairs = new HashMap<Character, Character>();

    static {
        open_syms.add('{');
        open_syms.add('(');
        open_syms.add('[');
        closed_syms.add('}');
        closed_syms.add(')');
        closed_syms.add(']');
        //pairs.put('{','}');
        pairs.put('}', '{');
        //pairs.put('(',')');
        pairs.put(')', '(');
        //pairs.put('[',']');
        pairs.put(']', '[');

    }

    public static boolean validateParans(String sym) {
        char[] symbols = sym.toCharArray();
        Stack<Character> syms = new Stack<Character>();
        Character poped_elem = null;

        for (int i = 0; i < symbols.length; i++) {

            if (open_syms.contains(symbols[i])) {
                syms.push(symbols[i]);
            } else if (closed_syms.contains(symbols[i])) {
                if (!syms.empty()) {
                    poped_elem = syms.pop();
                } else {
                    return false;
                }
                if (!poped_elem.equals(pairs.get(symbols[i]))) {
                    return false;
                }
            }
        }
        return syms.empty();
    }

    //Elegant short way of writing the same program
    public static boolean isBalanced(String expression) {
        if ((expression.length() % 2) == 1) return false;
        else {
            Stack<Character> s = new Stack<>();
            for (char bracket : expression.toCharArray())
                switch (bracket) {
                    case '{':
                        s.push('}');
                        break;
                    case '(':
                        s.push(')');
                        break;
                    case '[':
                        s.push(']');
                        break;
                    default:
                        if (s.isEmpty() || bracket != s.peek()) {
                            return false;
                        }
                        s.pop();
                }
            return s.isEmpty();
        }
    }
}
