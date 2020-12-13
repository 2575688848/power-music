package com.ytp.music.guava;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.ytp.music.entity.SongDO;

import java.util.Arrays;
import java.util.List;

/**
 * @author pinge
 */
public class Test {

    public static void main(String[] args) {
        SongDO songDO = new SongDO();
        songDO.setSinger("ddd");
        String s = "1,2,4";
        // System.out.println(Arrays.asList(s.split(",")).get(1));
        SongDO songDO1 = MoreObjects.firstNonNull(songDO, new SongDO());
        // System.out.println(songDO1);
//       /* System.out.println(possible.isPresent());
//        System.out.println(possible.get());*/
//        SongDO songDO2 = Preconditions.checkNotNull(songDO);
//        System.out.println(Objects.equal("a", "a"));
//        System.out.println(Objects.equal(songDO, songDO1));
//
//        System.out.println(MoreObjects.toStringHelper("MyObject").add("x", 1).addValue(1234).toString());
//        System.out.println(MoreObjects.toStringHelper("MyObject").add("x", songDO));
//
//        Integer value1 =  5;
//        Optional<Integer> a = Optional.fromNullable(value1);
//
//        System.out.println(a.isPresent());
//
//        List<String> s = Arrays.asList("ba","ab","a","b");
//        System.out.println(findLongestWord("bab", s));
        double a = 1536.71 - 143.38;
        double b = 1536.71 / a;
        System.out.println(b);
        double c = Math.pow(b, 1.0/5) - 1;
        System.out.println(c);
    }
    public static String findLongestWord(String s, List<String> d) {
        char[] source = s.toCharArray();
        int longWord = 0;
        String sa = "";
        for(String s1 : d) {
            int count = 0;
            int i = 0;
            int j = 0;
            char[] a = s1.toCharArray();
            while (i < source.length && j < a.length) {
                if (source[i] == a[j]) {
                    count++;
                    i++;
                    j++;
                }else {
                    i++;
                }
            }
            if (j >= a.length && longWord < count) {
                longWord = count;
                sa = s1;
            }
            if (j >= a.length && longWord == count && sa.compareTo(s1) > 0) {
                sa = s1;
            }
        }
        return sa;
    }
}
