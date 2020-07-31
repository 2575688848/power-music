package com.ytp.music.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author pinge
 */
public class DoublePointProblem {

    public static void main(String[] args) {
    }

    /**
     * 两数平方和等于某个数
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;
        while (a < b) {
            if ((numbers[a] + numbers[b]) < target) {
                a++;
            } else if ((numbers[a] + numbers[b]) > target) {
                b--;
            } else {
                break;
            }
        }
        return new int[]{a + 1, b + 1};
    }

    /**
     * 反转字符串中的元音字符
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] b = s.toCharArray();
        int i = 0, j = b.length - 1;
        char temp;
        while (i < j) {
            while (i < j && !list.contains(b[i])) {
                i++;
            }
            while (i < j && !list.contains(b[j])) {
                j--;
            }
            if (b[i] != b[j]) {
                temp = b[i];
                b[i] = b[j];
                b[j] = temp;
            }
            i++;
            j--;
        }
        return String.valueOf(b);
    }
}
