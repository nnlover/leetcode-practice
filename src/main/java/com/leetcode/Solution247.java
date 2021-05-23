package com.leetcode;

import java.util.List;

class Solution247 {
    /**
     * 注；是将数字旋转180度，或者上下颠倒后一样则是中心对称
     * https://leetcode-cn.com/problems/strobogrammatic-number-ii/
     */
    public List<String> findStrobogrammatic(int n) {

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

    public static char num[] = new char[]{'0',
            '1',
            '6',
            '8',
            '9'};

    private void takeStrobogrammatic(List<String> ans, int rotateCnt) {
        if(rotateCnt > 0){
            return ;
        }
        for (int i=0; i< num.length; i++){
            String tp = num[i] + takeStrobogrammatic(rotateCnt);
        }
    }
}