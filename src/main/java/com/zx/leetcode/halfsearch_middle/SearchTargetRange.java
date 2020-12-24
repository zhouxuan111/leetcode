package com.zx.leetcode.halfsearch_middle;

/**
 * 查询给定目标值在数据中的开始位置和结束位置
 * @author zhouxuan
 * @date 2020/12/24 9:49 上午
 */
public class SearchTargetRange {

    /**
     * 题目描述：给定一个按照升序排序的数组nums和一个目标值target ,找出给定目标值的开始位置和结束位置
     * 如果数组中不存在目标值 target 返回 [-1,-1]
     */

    /**
     * 个人思路：分两次二分，分别找出左右边界
     */

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        //分别寻找左右边界
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;
        boolean flag = false;
        //寻找左边界
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[ mid ] > target) {
                high = mid - 1;
            }
            else if (nums[ mid ] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
                flag = true;
            }
        }

        int left = low;
        low = 0;
        high = nums.length - 1;
        mid = low + (high - low) / 2;
        boolean rightFlag = false;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[ mid ] > target) {
                high = mid - 1;
            }
            else if (nums[ mid ] < target) {
                low = mid + 1;
            }
            else {
                low = mid + 1;
                rightFlag = true;
            }
        }
        int right = high;
        if (false == false && rightFlag == false) {
            return new int[] {-1, -1};
        }

        return new int[] {left, right};
    }

    public static void main(String[] args) {
        int[] nums = {};
        int[] res = searchRange(nums, 0);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[ i ]);
        }
    }

}
