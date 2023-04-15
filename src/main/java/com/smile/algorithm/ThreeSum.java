package com.smile.algorithm;

import java.util.*;

/**
 * @Description
 * @ClassName ThreeSum
 * @Author smile
 * @date 2021.09.21 16:26
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums, int remainTarget) {
        if (null == nums || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = remainTarget - nums[i];
            int startIdx = i + 1;
            int endIdx = nums.length - 1;
            while (startIdx < endIdx) {
                int result = nums[startIdx] + nums[endIdx];
                if (target == result) {
                    res.add(Arrays.asList(nums[i], nums[startIdx], nums[endIdx]));
                    startIdx++;
                    endIdx--;
                } else if (target < result) {
                    endIdx--;
                } else {
                    startIdx++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (null == nums || nums.length < 4) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int remainTarget = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int LeftTarget = remainTarget - nums[j];
                int startIdx = j + 1;
                int endIdx = nums.length - 1;
                while (startIdx < endIdx) {
                    int result = nums[startIdx] + nums[endIdx];
                    if (LeftTarget == result) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[startIdx], nums[endIdx]));
                        startIdx++;
                        endIdx--;
                    } else if (LeftTarget < result) {
                        endIdx--;
                    } else {
                        startIdx++;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static int threeSumNearest(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return 0;
        }
        int best = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int startIdx = i + 1;
            int endIdx = nums.length - 1;
            while (startIdx < endIdx) {
                int result = nums[i] + nums[startIdx] + nums[endIdx];
                int nearestValue = Math.abs(result-target);
                if (nearestValue <= Math.abs(best - target)) {
                    best = result;
                }
                if (target < result) {
                    endIdx--;
                } else {
                    startIdx++;
                }
            }
        }
        return best;
    }


    public static void main(String[] args) {
//        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4}, 0);
//        List<List<Integer>> lists = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        int result = threeSumNearest(new int[]{0, 0, 0}, 1);
        System.out.println(result);
    }
}
