package com.zx.leetcode.halfsearch;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * @author zhouxuan
 * @date 2020/12/15 9:54 上午
 */
public class Intersection {

    /**
     * 题目描述：给定两个函数，编写一个函数计算他们的交集
     * 输出结果中每个元素一定是唯一的，不考虑输出结果的顺序
     */

    /**
     * 解法1：set集合
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        if (0 == nums1.length || 0 == nums2.length) {
            return new int[ 0 ];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[ i ]);
        }
        for (int i = 0; i < nums2.length; i++) {
            //存在 即交集
            if (set1.contains(nums2[ i ])) {
                set2.add(nums2[ i ]);
            }
        }
        int[] res = new int[ set2.size() ];
        int index = 0;
        for (Integer s : set2) {
            res[ index++ ] = s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = intersection(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[ i ]);
        }
    }
}
