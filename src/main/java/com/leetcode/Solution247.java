package com.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution247 {
    /**
     * 注；是将数字旋转180度，或者上下颠倒后一样则是中心对称
     * https://leetcode-cn.com/problems/strobogrammatic-number-ii/
     */
    public List<String> findStrobogrammatic(int n) {
        return null;
    }


    public boolean isStrobogrammatic(String num) {

        int r = num.length() - 1;
        char[] rotate = new char[num.length()];
        for (int i = 0; i < num.length(); i++) {
            int index = look(num.charAt(i));
            if (index >= 0) {
                rotate[r--] = lookup[index][1];
            } else {
                return false;
            }
        }
        return String.valueOf(rotate).equals(num);
    }

    public static char[][] lookup = new char[][]{
            {'0', '0'},
            {'1', '1'},
            {'6', '9'},
            {'8', '8'},
            {'9', '6'},
    };


    private int look(char a) {
        for (int i = 0; i < 5; i++) {
            if (lookup[i][0] == a) {
                return i;
            }
        }
        return -1;
    }

    public static char[] num = new char[]{'0', '1', '6', '8', '9'};
    public static String[] numStr = new String[]{"0", "1", "6", "8", "9"};

    private void takeStrobogrammatic(List<String> ans, int rotateCnt) {
        if (rotateCnt > 0) {
            return;
        }
        for (int i = 0; i < num.length; i++) {
            String a = String.valueOf(num[i]);
            for (int j = 0; j < num.length; j++) {
                String s = a + num[j];
                ans.add(s);
            }
        }
    }

    /**
     * 递归写法的生成长度为 n de 全排列
     *
     * @param ans
     * @param prefix
     * @param index
     * @param deep
     */
    public static void loop(List<String> ans, String prefix, int index, int deep) {
        if (index == deep) {
            ans.add(prefix);
            return;
        }
        ++index;
        for (int i = 0; i < num.length; i++) {
            loop(ans, prefix + num[i], index, deep);
        }

    }

    /**
     * 非递归写法的生成长度为n的全排列
     *
     * @param depp
     * @return
     */
    public static List<String> loop2(int depp) {

        int l = 0;
        List<String> res = getPrefixs();
        while (l < depp) {
            List<String> prefix = getPrefixs();
            List<String> tmp = new ArrayList<>((int) Math.pow(prefix.size(), depp));
            for (String s : res) {
                for (String prefix1 : prefix) {
                    tmp.add(s + prefix1);
                }
            }
            res = tmp;
            l++;
        }
        return res;
    }

    private static List<String> getPrefixs() {
        return Arrays.asList(numStr);
    }

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        loop(list, "", 0, 3);
        System.out.println(list.toString());
        System.out.println(loop2(2).toString());
    }

}