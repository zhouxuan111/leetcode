package com.zx.leetcode.halfsearch_easy;

/**
 * 魔术索引
 * @author zhouxuan
 * @date 2020/12/23 9:44 上午
 */
public class MagicIndex {

    /**
     * 题目描述：魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，
     * 编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个
     * 说明：nums长度在[1, 1000000]之间；此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
     */

    /**
     * 简单粗暴：全部遍历
     * @param nums
     * @return
     */
    public static int findMagicIndex(int[] nums) {

        // Set<Integer> index = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[ i ]) {
                return nums[ i ];
            }
            if (nums[ i ] > i + 1) {
                //如果nums[i]大于i+1,我们就让i加上nums[i] - 1，
                // 这里减1的目的是为了抵消上面for循环中的i++。
                //这里判断的时候为什么是nums[i] > i + 1而不是
                //nums[i] > i ,因为如果num[i]只比i大1的话，
                //直接执行上面的i++就可以了，没必要再执行下面的计算
                i = nums[ i ] - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(findMagicIndex(nums));
    }

}
