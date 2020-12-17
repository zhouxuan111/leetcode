package com.zx.leetcode.halfsearch;

/**
 * 二分查找
 * @author zhouxuan
 * @date 2020/12/17 9:39 上午
 */
public class HalfSearch {

    /**
     * 题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */

    /**
     * 正常二分解法
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[ mid ] == target) {
                return mid;
            }
            else if (nums[ mid ] < target) {
                low = mid + 1;
            }
            else if (nums[ mid ] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        System.out.println(search(nums, 5));
    }
}
