package com.ytp.music.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pinge
 */
public class Test {

    public static void main(String[] args) {
        int a = (int) Math.sqrt(10);
        System.out.println(a);
        int b = 1;
        System.out.println(a == b);

        String s = "jdddj?jjd?jd";
        System.out.println(s.indexOf("?jjd"));
        System.out.println(s.substring(0, s.indexOf("?jjd")));

        System.out.println(reverseVowels("leetcode"));
    }

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
