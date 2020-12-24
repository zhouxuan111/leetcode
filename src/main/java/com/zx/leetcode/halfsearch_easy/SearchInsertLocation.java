package com.zx.leetcode.halfsearch_easy;

/**
 * 搜索插入位置
 * @author zhouxuan
 * @date 2020/12/9 9:53 上午
 */
public class SearchInsertLocation {

    /**
     * 问题描述：给定一个排序数组和目标值，在数组中找到目标值并且返回其索引，如果目标值不在数组中，返回他将被插入位置的索引。
     * 算法解析：时间复杂度：O(logn)
     * 官方思路：
     *  插入位置pos ，成立条件：nums[pos-1]<target<=nums[pos]，若存在目标值，返回的也是pos，所以
     *  合并的条件是：找到第一个大于等于target的索引值，返回即可
     * 个人思路：
     *  分两种情况
     *      如果找到目标值 直接返回其索引值
     *      如果没有找到，直接返回low位置，low位置代表被插入的位置
     *
     */

    /**
     * 个人实现
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        //low <= high退出循环
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
        return low;
    }

    /**
     * 官方给出的算法
     * @param nums
     * @param target
     * @return
     */
    public static int officialSearchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int mid = (low + high) / 2;

        //将插入位置初始为数组的长度，是因为可能存在target比数组的所有元素都大，那么数组长度对应的索引位置就是待插入的位置
        int pos = nums.length;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[ mid ] >= target) {
                pos = mid;
                high = mid - 1;
            }
            else if (nums[ mid ] < target) {
                low = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(officialSearchInsert(nums, 2));
    }
}
