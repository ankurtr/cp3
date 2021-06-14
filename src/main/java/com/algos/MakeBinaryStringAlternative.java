package com.algos;

public class MakeBinaryStringAlternative {
    public int minFlips(String s) {
        int n = s.length();
        StringBuilder str1 = new StringBuilder(s).append(s);
        String str = str1.toString();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            s1.append((i % 2 == 0) ? "1" : "0");
            s2.append((i % 2 == 0) ? "0" : "1");
        }

        int ans1, ans2, ans;
        ans1 = 0;
        ans2 = 0;
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != s1.charAt(i)) {
                ans1++;
            }

            if (str.charAt(i) != s2.charAt(i)) {
                ans2++;
            }

            if (i >= s.length()) {
                if (str.charAt(i - n) != s1.charAt(i - n)) {
                    ans1--;
                }
                if (str.charAt(i - n) != s2.charAt(i - n)) {
                    ans2--;
                }
            }

            if (i >= s.length() - 1) {
                ans = Math.min(ans, Math.min(ans1, ans2));
            }
        }
        return ans;
    }
}
