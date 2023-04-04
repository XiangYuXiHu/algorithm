package com.smile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @Description
 * @ClassName TwoSum
 * @Author smile
 * @date 2021.09.19 20:46
 */
public class TwoSum {

//    public static int[] twoSum(int[] nums, int target) {
//        if (null == nums && nums.length == 0) {
//            return null;
//        }
//
//        Map<Integer, Integer> valueAndPos = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int remainValue = target - nums[i];
//            if (valueAndPos.get(remainValue) != null) {
//                return new int[]{i, valueAndPos.get(remainValue)};
//            } else {
//                valueAndPos.put(nums[i], i);
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 7, 11, 15};
        int[] twoSum = twoSum(num, 9);
        Arrays.stream(twoSum).forEach(System.out::print);
    }

    public static int[] twoSum(int[] num, int target) {
        if (num == null || num.length == 0) {
            return null;
        }

        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int remain = target - num[i];
            if (pos.get(remain) != null) {
                return new int[]{pos.get(remain), i};
            } else {
                pos.put(num[i], i);
            }
        }
        return null;
    }


}