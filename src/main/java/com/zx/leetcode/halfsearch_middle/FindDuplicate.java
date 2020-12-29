package com.zx.leetcode.halfsearch_middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找重复数
 * @author xuanzhou
 * @date 2020/12/29 10:12 上午
 */
public class FindDuplicate {

    /**
     * 题目描述：给定一个n+1长度的整数数组 nums,其数字都在1~n之间（包括1到n）,可知至少存在一个重复的数组，假设只有一个重复的整数，
     * 请找出这个整数。
     * 说明：不能更改原数组（假设数组是只读的）；只能使用额外的 O(1) 的空间；时间复杂度小于 O(n2) ；数组中只有一个重复的数字，但它可能不止重复出现一次。
     */

    /**
     * 个人解题思路:暴力循环，使用List集合存储
     * @param nums
     * @return
     */

    public static int findDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[ i ])) {
                res = nums[ i ];
                break;
            }
            list.add(nums[ i ]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums));
    }
}
