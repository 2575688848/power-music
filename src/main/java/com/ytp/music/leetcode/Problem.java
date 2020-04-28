package com.ytp.music.leetcode;

public class Problem {

    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;
        while (a < b) {
            if ((numbers[a] + numbers[b]) < target) {
                a++;
            } else if ((numbers[a] + numbers[b]) > target){
                b--;
            } else {
                break;
            }
        }
       return new int[]{a + 1, b + 1};
    }
}
