package com.ytp.music.entity.netease;

import java.util.Scanner;

public class Test {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String t = in.nextLine();
//        String p = in.nextLine();
//        if (t == null || t.isEmpty() || p == null || p.isEmpty()) {
//            System.out.println("No");
//            return;
//        }
//        char[] ts = t.toCharArray();
//        char[] ps = p.toCharArray();
//        boolean flag = false;
//        int result = 0;
//        for (int i = 0; i < ts.length; i++) {
//            if (ts[i] == ps[0]) {
//                int j = 0;
//                int k = i;
//                result = i + 1;
//                while (j < ps.length) {
//                    if (ts[k] == ps[j]) {
//                        if (j == (ps.length - 1)) {
//                            flag = true;
//                            break;
//                        }
//                        k++;
//                        j++;
//                    } else {
//                        break;
//                    }
//                }
//                if (flag) {
//                    break;
//                }
//            }
//        }
//        if (flag) {
//            System.out.println(result);
//        } else {
//            System.out.println("No");
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int length = sc.nextInt();
//        int[] tasks = new int[length];
//        for(int i = 0; i < length; i++){
//            tasks[i] = sc.nextInt();
//        }
//        int sum = 0;
//        int temp = 0;
//        int a = 0;
//        for (int i = 0; i < length; i++) {
//            a = (tasks[i] + temp) / n;
//            if (a >= 1) {
//                temp = (tasks[i] + temp) % n;
//            }
//            if (a == 0) {
//                a = 1;
//                temp = 0;
//            }
//            sum += a;
//        }
//        if (temp != 0) {
//            sum = sum + 1;
//        }
//        System.out.println(sum);
//    }

    /**
     * 第一行输入两个数字：n, m 表示一个 n*m 的一个二维数组
     * 输入的值要么是 1 要么是 0。1 表示机房中的一台机器，0 表示不存在机器。
     * 如果一行或一列中相邻的都是1 ，则表示可以组成一个局域网。
     * 求最大的局域网中一共有多少机器
     *
     * 例：
     * 2 2
     * 0 1 1 0
     * 0 1 0 0
     * 1 0 0 1
     * 1 0 0 1
     *
     * 输出 3
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] net = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                net[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (net[i][j] == 1) {
                    net[i][j] = -1;
                    temp = search(net, i, j, n, m , 1);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static int search(int[][] net, int i, int j, int n, int m, int result) {
        if (j - 1 >= 0) {
            if (net[i][j - 1] == 1) {
                result += 1;
                net[i][j - 1] = -1;
                result = search(net, i, j - 1, n, m, result);
            }
        }
        if (j + 1 < m) {
            if (net[i][j + 1] == 1) {
                result += 1;
                net[i][j + 1] = -1;
                result = search(net, i, j + 1, n, m, result);
            }
        }
        if (i - 1 >= 0) {
            if (net[i - 1][j] == 1) {
                result += 1;
                net[i - 1][j] = -1;
                result = search(net, i - 1, j, n, m, result);
            }
        }
        if (i + 1 < n) {
            if (net[i + 1][j] == 1) {
                result += 1;
                net[i + 1][j] = -1;
                result = search(net, i + 1, j, n, m, result);
            }
        }
        return result;
    }
}
