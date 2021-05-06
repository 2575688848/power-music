package com.ytp.music.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ytp
 */
@Data
public class MusicVideoDO{

    private String docid;

    private Long mv_id;

    private String mv_name;

    private String mv_pic_url;

    private Long play_count;

    private String publish_date;

    private String singer_name;

    private Long singerid;

    private String v_id;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        int j = 0;
        dfs(nums, ans, tmp, isVisited, j);
        return  ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> tmp, boolean[] isVisited, int j) {
        if (j == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                tmp.add(nums[i]);
                dfs(nums, ans, tmp, isVisited, j + 1);
                isVisited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            t.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    t.add(nums[j]);
                 }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(1 << 3);
        if ((0 & (1 << 0)) != 0) {
            System.out.println("qwer");
        }
        for (int mask = 0; mask < (1 << 3); ++mask) {
            for (int i = 0; i < 3; ++i) {
                System.out.print(mask & (1 << i));

            }
            System.out.println();
        }
    }

    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] maxRight = new int[n];
        int[] minLeft = new int[n];
        int m = A[0];
        for (int i = 0; i < n; i++) {
            m = Math.max(m, A[i]);
            maxRight[i] = m;
        }
        m = A[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            m = Math.min(m, A[i]);
            minLeft[i] = m;
        }
        for (int i = 1; i < n; i++) {
            if (maxRight[i - 1] <= minLeft[i]) {
                return i;
            }
        }
        return 0;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int leftIndex = 0;
        int result = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                result = Math.max(i - leftIndex, result);
                leftIndex = i;
            }
            map.put(chars[i], i);
        }
        return result;
    }
}














