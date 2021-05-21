package com.leetcode;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/21 4:36 下午
 */
public class Solution161 {
    /**
     * https://leetcode-cn.com/problems/one-edit-distance/
     *
     * @param s
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        return isOneDis(s, t, 0);
    }

    public String removeOneChar(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }

    public boolean isOneDis(String a, String b, int index) {
        if (a.length() == b.length() && a.length() == 0 || Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        index++;
        return a.length() > b.length() ? isOneDis(removeOneChar(a, index), b, index) : (
                a.length() < b.length() ? isOneDis(a, removeOneChar(b, index), index) :
                        replaceOneIsSame(a, b));
    }

    private boolean replaceOneIsSame(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }

}
