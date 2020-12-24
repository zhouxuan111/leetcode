package com.zx.leetcode.halfsearch_easy;

/**
 * 判断是否是完全平方数
 * @author zhouxuan
 * @date 2020/12/17 10:03 上午
 */
public class IsPerfectSquare {

    /**
     * 个人解法：错误
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long low = 2;
        long high = num / 2;
        long res;
        long mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            res = mid * mid;
            if (res == num) {
                return true;
            }
            else if (res > num) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * 官方解法
     * @param num
     * @return
     */
    public static boolean isPerfectSquare2(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            }
            else {
                left = x + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
}
