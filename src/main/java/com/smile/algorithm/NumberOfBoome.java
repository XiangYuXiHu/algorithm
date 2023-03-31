package com.smile.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 回旋镖的数量
 * 回旋镖形状的三元组结构，要求第一个点和第二个点之间的距离跟第一个点和第三个点之间的距离相等。
 *
 * @Description
 * @ClassName NumberOfBoome
 * @Author smile
 * @date 2023.03.31 22:44
 */
public class NumberOfBoome {

    public static void main(String[] args) {
        int[][] points = {{1, 0},
                          {0, 0},
                          {2, 0}};
        int result = numberOfBoom(points);
        System.out.println(result);
    }

    public static int numberOfBoom(int[][] points) {
        int length = points.length;
        HashMap<Integer, Integer> disCount = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                Integer dis = x * x + y * y;
                disCount.put(dis, disCount.getOrDefault(dis, 0) + 1);
            }
        }

        int sum = 0;
        Set<Map.Entry<Integer, Integer>> entries = disCount.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer count = entry.getValue();
            sum += count * (count - 1);
        }
        return sum;
    }
}
