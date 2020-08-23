package com.az;

public class LargestArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{4,1,1,1}));
    }

    public static int maxArea(int[] nums) {
        int maxarea = 0, l = 0, r = nums.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(nums[l], nums[r]) * (r - l));
            if (nums[l] < nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }
}
