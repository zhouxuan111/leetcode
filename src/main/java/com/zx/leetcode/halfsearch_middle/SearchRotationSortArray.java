package com.zx.leetcode.halfsearch_middle;

/**
 * 搜索旋转排序数组
 * @author zhouxuan
 * @date 2020/12/28 10:00 上午
 */
public class SearchRotationSortArray {

    /**
     * 题目描述：升序排列的整数数组nums在预先未知的某个点上进行旋转，例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）
     * 请在数组中搜索target,如果数组中存在这个值，返回他的索引，否则返回-1；
     * 提示： 1 <= nums.length <= 5000 ；-10^4 <= nums[i] <= 10^4 ；nums 中的每个值都 独一无二；nums 肯定会在某个点上旋转；-10^4 <= target <= 10^4
     */

    /**
     * 解题思路：判断由mid分成的两部分哪部分是有序
     * 这启示我们可以在常规二分搜索的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分搜索的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分：
     * 如果 [l, mid - 1] 是有序数组，且 target 的大小满足[nums[l],nums[mid])，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
     * 如果 [mid, r] 是有序数组，且 target 的大小满足 (nums[mid+1],nums[r])，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。
     */

    public static int search(int[] nums, int target) {

        if (nums.length == 1) {
            return nums[ 0 ] == target ? 0 : -1;
        }
        //二分法查找到旋转的点 - nums[mid]<nums[mid-1]
        int low = 0;
        int high = nums.length - 1;
        int mid = (high + low) / 2;

        while (low <= high) {
            mid = (high + low) / 2;
            if (target == nums[ mid ]) {
                return mid;
            }
            //前半部分有序
            if (nums[ 0 ] <= nums[ mid ]) {
                if (nums[ 0 ] <= target && target < nums[ mid ]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            //后半部分有序
            else {
                if (nums[ mid ] < target && target <= nums[ nums.length - 1 ]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }
}
