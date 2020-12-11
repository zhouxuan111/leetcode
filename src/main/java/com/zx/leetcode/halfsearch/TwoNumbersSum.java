package com.zx.leetcode.halfsearch;

import java.util.Arrays;

/**
 * 两数之和 - 输入有序之和
 * @author zhouxuan
 * @date 2020/12/11 9:49 上午
 */
public class TwoNumbersSum {

    /**
     * 题目描述：
     * 给定一个按照升序的数组，找到两个数使他们相加之和等于目标数，函数应该返回两个下标值index1,和index2,其中index1小于index2
     * 说明：index1和index2不是从0开始的 | 假设每个输入只有一对唯一的答案，而且你不可以重复使用相同的元素。
     * 个人解题思路：二分法
     * 首先判断mid位置的值 是否大于 target，若大于，high = mid-1;
     * 小于target的时候，判断num[low]+num[high]与target的关系，
     * 相等：返回
     * 小于: low +1
     * 大于：high -1
     */

    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (numbers[ mid ] > target) {
                high = mid - 1;
            }
            else {
                if (numbers[ low ] + numbers[ high ] == target) {
                    break;
                }
                else if (numbers[ low ] + numbers[ high ] < target) {
                    low = low + 1;
                }
                else if (numbers[ low ] + numbers[ high ] > target) {
                    high = high - 1;
                }
            }
        }
        int[] res = {low + 1, high + 1};
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int[] res = twoSum(numbers, -1);
        System.out.println(Arrays.toString(res));
    }
}
