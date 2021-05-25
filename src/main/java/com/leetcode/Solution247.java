package com.leetcode;


import java.util.*;

class Solution247 {
    /**
     * 注；是将数字旋转180度，或者上下颠倒后一样则是中心对称
     * https://leetcode-cn.com/problems/strobogrammatic-number-ii/
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        Map<Character, Character> lookupMap = new HashMap<>(6);
        lookupMap.put('0', '0');
        lookupMap.put('1', '1');
        lookupMap.put('6', '9');
        lookupMap.put('8', '8');
        lookupMap.put('9', '6');
        Set<String> existSet = new HashSet<>();
        doFind(ans, "", "", 0, n, lookupMap, existSet);
        return ans;
    }

    public void doFind(List<String> ans, String prefix, String rotate, int index, int deep, Map<Character, Character> lookupMap, Set<String> existSet) {
        if (index == deep) {
            if (deep > 1 && prefix.startsWith("0")) {
                return;
            }
            if (prefix.equals(rotate)) {
                ans.add(prefix);
                existSet.add(prefix);
            }
            return;
        }
        if (filter(prefix, deep)) {
            return;
        }
        ++index;
        for (int i = 0; i < num.length; i++) {
            if (!existSet.contains(prefix)) {
                doFind(ans, prefix + num[i], lookupMap.get(num[i]) + rotate, index, deep, lookupMap, existSet);
            }
        }

    }

    private boolean filter(String prefix, int deep) {
        if (prefix.startsWith("0")) {
            return true;
        }
        int mid = deep / 2;
        if (prefix.length() <= mid || deep < 4) {
            return false;
        }
        if (deep % 2 == 1) {
            return '6' == prefix.charAt(mid) || '9' == prefix.charAt(mid);
        } else {
            //中间只能是 11 69 96 88；
            String sub = prefix.substring(mid - 1, mid + 1);
            return !("00".equals(sub) || "11".equals(sub) || "69".equals(sub) || "96".equals(sub) || "88".equals(sub));
        }
    }


    public boolean isStrobogrammatic(String num, Map<Character, Character> lookupMap) {

        int r = num.length() - 1;
        char[] rotate = new char[num.length()];
        for (int i = 0; i < num.length(); i++) {
            rotate[r--] = lookupMap.get(num.charAt(i));
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

    public static char[] num = new char[]{'0', '1', '6', '8', '9'};


    private int look(char a) {
        for (int i = 0; i < 5; i++) {
            if (lookup[i][0] == a) {
                return i;
            }
        }
        return -1;
    }

    public static String[] numStr = new String[]{"0", "1", "6", "8", "9"};

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
        //loop(list, "", 0, 10);
        System.out.println(list.toString());
        System.out.println(loop2(12).toString());
    }

}