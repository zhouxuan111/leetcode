package com.zx.leetcode.halfsearch_easy;

/**
 * 寻找0~n-1数组中缺失的数字
 * @author zhouxuan
 * @date 2020/12/18 9:53 上午
 */
public class MissingNumber {

    /**
     * 题目描述：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0 ~ n-1之内，在范围0~n-1的n个数字只有
     * 一个数字不在数组中，请找出他。1 <= 数组长度 <= 10000
     */

    /**
     * 算法解析
     * 初始化： 左边界 i = 0，右边界 j = len(nums) - 1；代表闭区间 [i, j] 。
     * 循环二分： 当 i≤j 时循环 （即当闭区间 [i, j] 为空时跳出） ；
     * 计算中点 m = (i + j) // 2，其中 "//" 为向下取整除法；
     * 若 nums[m] = m ，则 “右子数组的首位元素” 一定在闭区间 [m + 1, j][m+1,j] 中，因此执行 i = m + 1；
     * 若 nums[m] ！=m ，则 “左子数组的末位元素” 一定在闭区间 [i, m - 1][i,m−1] 中，因此执行 j = m - 1；
     * 返回值： 跳出时，变量 i 和 j 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 i 即可。
     */

    public static int missingNumber(int[] nums) {
        int low = 0;

        int high = nums.length - 1;

        int mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[ mid ] == mid) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

}
