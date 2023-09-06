package com.smile.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 找到最小的k个数
 *
 * @Description
 * @ClassName FindKthLeast
 * @Author smile
 * @date 2021.06.06 17:10
 */
public class FindKthLeast {

    private static Random random = new Random();

    static int Partition(int[] input, int start, int end) {
        int index = getRandom(start, end);
        int small = start - 1;
        swap(input, index, end);
        for (int i = start; i < end; i++) {
            if (input[i] < input[end]) {
                small++;
                if (small != i) {
                    swap(input, small, i);
                }
            }
        }
        small++;
        swap(input, small, end);
        return small;
    }

    static void swap(int[] input, int first, int two) {
        int temp = input[first];
        input[first] = input[two];
        input[two] = temp;
    }

    static int getRandom(int start, int end) {
        return random.nextInt(end) % (end + 1 - start) + start;
    }

    public static List<Integer> getKthLeast(int[] input, int k) {
        if (input == null || input.length == 0 || k < 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = input.length - 1;
        int index = Partition(input, start, end);
        while (index != k) {
            if (index < k) {
                index = Partition(input, index + 1, end);
            } else {
                index = Partition(input, start, index - 1);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> kthLeast = getKthLeast(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 3);
        System.out.println(kthLeast);
    }
}
