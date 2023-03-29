package com.smile.algorithm;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false
 * <p>
 * 滑动窗口（要么前面指针走要么后面指针走）
 *
 * @Description
 * @ClassName NearbyDuplicate
 * @Author smile
 * @date 2023.03.29 21:31
 */
public class NearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 8, 1, 5, 3, 1};
        boolean result = containNearByDuplicate(nums, 3);
        System.out.println(result);
    }

    public static boolean containNearByDuplicate(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return false;
        }
        int p = 0;
        int q = p + 1;
        int len = nums.length;
        while (q < len) {
            if (nums[p] == nums[q]) {
                if (q - p <= k) {
                    return true;
                }
            }
            if (q - p > k) {
                p++;
            } else {
                q++;
            }
        }
        return false;
    }
}
