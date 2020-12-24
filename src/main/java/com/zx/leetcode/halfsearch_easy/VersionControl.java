package com.zx.leetcode.halfsearch_easy;

/**
 * 查询第一个错误版本
 * @author zhouxuan
 * @date 2020/12/22 9:40 上午
 */
public class VersionControl {

    /**
     * 判断时候是错误版本
     * @param version
     * @return
     */
    boolean isBadVersion(int version) {
        return false;
    }

}

class Solution extends VersionControl {

    /**
     * 题目描述：你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     */

    /**
     * 解题思路：二分法
     */
    public int firstBadVersion(int n) {

        int low = 0;
        int high = n - 1;
        //重点  计算mid
        int mid = low + (high - low) / 2;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid) == false) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}