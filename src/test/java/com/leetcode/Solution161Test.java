package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/21 7:09 下午
 */
public class Solution161Test {

    @Test
    public void isOneEditDistance() {
        assertTrue(new Solution161().isOneEditDistance("a", "b"));
        assertTrue(new Solution161().isOneEditDistance("ab", "b"));
        assertTrue(new Solution161().isOneEditDistance("a", "ab"));
        assertTrue(new Solution161().isOneEditDistance("ac", "bc"));
        assertTrue(new Solution161().isOneEditDistance("acb", "abb"));
        assertFalse(new Solution161().isOneEditDistance("acd", "bc"));
        assertTrue(new Solution161().isOneEditDistance("aaa", "baa"));
    }
}