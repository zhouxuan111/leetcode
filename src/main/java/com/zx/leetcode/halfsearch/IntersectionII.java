package com.zx.leetcode.halfsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个数组的集合II
 * @author zhouxuan
 * @date 2020/12/15 11:16 上午
 */
public class IntersectionII {

    /**
     * 给定两个数组，求两个数组的集合，输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     */

    /**
     * 官方解法:hash表 、排序+双指针
     */
    /**
     * 个人解法：双指针,使用数组存储下标
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();

        List<Integer> index = new ArrayList<>();

        while (i < nums1.length) {
            for (int k = j; k < nums2.length; k++) {
                if (nums1[ i ] == nums2[ k ]) {
                    if (!index.contains(k)) {
                        res.add(nums1[ i ]);
                        index.add(k);
                        break;
                    }
                }
            }
            i++;
        }
        int[] result = new int[ res.size() ];
        for (int k = 0; k < res.size(); k++) {
            result[ k ] = res.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersect(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[ i ]);
        }
    }
}
