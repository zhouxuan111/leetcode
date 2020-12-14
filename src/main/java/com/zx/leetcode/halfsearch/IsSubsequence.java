package com.zx.leetcode.halfsearch;

/**
 * 查找子序列
 * @author zhouxuan
 * @date 2020/12/14 9:44 上午
 */
public class IsSubsequence {

    /**
     * 题目描述：给定字符串s和t ，判断s是否是t的子串。字符串的一个子序列是原字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置
     * 形成的新字符串
     * 进阶：如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，
     * 你会怎样改变代码？
     */

    /**
     * 个人思路：双指针的优化
     * 首先考虑给定字符串的边界：空串的情况
     * 遍历给定子串：（while）终止条件，子串遍历完成
     * 将子串中的字符在父串中查找，找到，继续判断下一个字符；未找到，判断父串是否遍历到最后一位，是的话，直接返回不是子串
     * 匹配到子串的一位字符后，下一次父串中循环位置从在上一位字符在父串中的位置的下一个开始。
     */

    public static boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        int i = 0;
        int j = 0;
        int len = s.length() - 1;
        boolean result = false;
        while (i <= len) {
            for (int k = j; k < t.length(); k++) {
                //匹配到字符,进行下一个字符匹配
                if (s.charAt(i) == t.charAt(k)) {
                    if (i == len) {
                        result = true;
                    }
                    //下一次查找从找的位置开始，因为子串是父串中有序的字符组成的。
                    j = k + 1;
                    break;
                }
                // 遍历到父串最后一位，result = false，就说明该位置字符不在数组中，直接返回false即可
                if (k == t.length() - 1 && result == false) {
                    return result;
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }
}
