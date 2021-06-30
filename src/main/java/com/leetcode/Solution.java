package com.leetcode;

class Solution {
    public int sumBase(int n, int k) {
        int answer=0;

        while(n>0) {
            answer+=(n%k);
            n/=k;
        }

        return answer;
    }
}