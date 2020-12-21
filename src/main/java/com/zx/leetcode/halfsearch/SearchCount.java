package com.zx.leetcode.halfsearch;

/**
 * 查找一个数字在排序数组中出现的次数
 * @author zhouxuan
 * @date 2020/12/21 9:49 上午
 */
public class SearchCount {

    /**
     * 题目描述：查找一个数字在排序数组中出现的次数
     */

    /**
     * 解法1：直接遍历
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[ i ] == target) {
                count++;
            }
        }

        return count;
    }

    /**
     * 解题思路：排序数组 nums中的所有数字 target形成一个窗口，记窗口的 左 / 右边界 索引分别为 left 和 right ，分别对应窗口左边 / 右边的首个元素。
     * 使用二分法分别找到 左边界 left 和 右边界 right ，易得数字 target的数量为 right - left - 1 。
     * 初始化： 左边界 i = 0 ，右边界 j = len(nums) - 1。
     * 循环二分： 当闭区间 [i, j]无元素时跳出；
     * 计算中点 m = (i + j) / 2 （向下取整）；
     * 若 nums[m] < target ，则 target 在闭区间 [m + 1, j]中，因此执行 i = m + 1；
     * 若 nums[m] > target ，则 target在闭区间 [i, m - 1]中，因此执行 j = m - 1；
     * 若 nums[m] = target ，则右边界 right 在闭区间 [m+1, j]中；左边界 left 在闭区间 [i, m-1]中。因此分为以下两种情况：
     * 若查找 右边界 right，则执行 i = m + 1 ；（跳出时 i 指向右边界）
     * 若查找 左边界 left ，则执行 j = m - 1 ；（跳出时 j 指向左边界）
     * 返回值： 应用两次二分，分别查找 right 和 left ，最终返回 right - left - 1即可。
     */
    public static int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        //寻找左边界
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[ mid ] >= target) {
                high = mid - 1;
            }
            else if (nums[ mid ] < target) {
                low = mid + 1;
            }
        }
        int left = high;
        //寻找右边界
        low = 0;
        high = nums.length - 1;
        mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[ mid ] <= target) {
                low = mid + 1;
            }
            else if (nums[ mid ] > target) {
                high = mid - 1;
            }
        }

        int right = low;

        return right - left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(search2(nums, 8));
    }
}
