package com.cp3;

import java.util.Stack;

/**
 * Created by ankur on 25/3/17.
 */
public class PostFixEval {


    public static Integer evaluate(String postfix) throws Exception {

        char[] elems = postfix.toCharArray();
        Stack<Integer> vals = new Stack<>();
        int x, y, res;
        x = 0;
        y = 0;
        res = 0;

        for (int i = 0; i < elems.length; i++) {

            switch (elems[i]) {
                case '/':
                case '*':
                case '+':
                case '-':
                    if (!vals.empty()) {
                        x = vals.pop();
                        if (!vals.empty()) {
                            y = vals.pop();
                        } else {
                            throw new Exception("Invalid expression");

                        }
                    } else {
                        throw new Exception("Invalid expression");
                    }

                    switch (elems[i]) {
                        case '/':
                            if (y != 0) {
                                res = y / x;
                            } else {
                                throw new Exception("Can't divide by zero");
                            }
                            break;
                        case '*':
                            res = y * x;
                            break;
                        case '+':
                            res = y + x;
                            break;
                        case '-':
                            res = y - x;
                            break;
                    }
                    vals.push(res);
                    break;
                default:
                    vals.push(Character.getNumericValue(elems[i]));
            }

        }
        if (!vals.empty())
            return vals.pop();
        return 0;

    }

}
