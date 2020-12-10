package com.zx.leetcode.halfsearch;

/**
 * x的平方根
 * @author zhouxuan
 * @date 2020/12/10 10:12 上午
 */
public class XSquareRoot {

    /**
     * 题目描述：实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     */

    /**
     * Java API 实现 ：
     * Math.sqrt(x) : 获取X的平方根
     * Math.floor(x)：对x向下取整
     * Math.ceil(x)：对X向上取整
     */

    public static int javaSqrt(int x) {
        Double res = Math.floor(Math.sqrt(x));
        return res.intValue();
    }

    /**
     * 二分法实现求X的平方根
     * 思路：x的平方根向下取整，那么就满足 k^2<=x， 那么就通过去mid * mid <= x即可
     * 则有序数组为 0 ~ x-1，取mid * mid <= x
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     */
    public static int halfSearchSqrt(int x) {
        //索引为 0 开始
        int low = 0;
        int high = x;
        //结果值
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 使用牛顿迭代法求平方根:C就是我们输入的值要求的平方根
     * 牛顿迭代公式  Xi+1 = 1/2(Xi+C/Xi)
     * 迭代结束：Xi+1 无限接近于 Xi
     * 时间复杂度：
     */
    public static int newtonIterSqrt(int x) {
        if (x == 0) {
            return -1;
        }
        double c = x;
        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + c / x0);
            if (Math.abs(xi - x0) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    public static void main(String[] args) {
        System.out.println(halfSearchSqrt(2147395599));
    }
}
