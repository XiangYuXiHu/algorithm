package com.smile.algorithm;

import java.util.TreeSet;

/**
 * 全排序
 *
 * @Description
 * @ClassName Permutation
 * @Author smile
 * @date 2021.06.27 16:15
 */
public class Permutation {

    /**
     * 递推参数： 当前固定位 x ；
     * 递推工作： 初始化一个 Set ，用于排除重复的字符；将第 x 位字符与 i∈ [x, len(c)] 字符分别交换，并进入下层递归；
     * 剪枝： 若 c[i] 在 Set​ 中，代表其是重复字符，因此 “剪枝” ；将 c[i] 加入 Set​ ，以便之后遇到重复字符时剪枝；
     * 固定字符： 将字符 c[i] 和 c[x] 交换，即固定 c[i] 为当前位字符；
     * 开启下层递归： 调用 dfs(x + 1) ，即开始固定第 x + 1 个字符；
     * 还原交换： 将字符 c[i] 和 c[x] 交换（还原之前的交换）；
     * <p>
     *
     * @param chars
     * @param pos
     * @param temp
     */
    public static void permutationSort(char[] chars, int pos, TreeSet<String> temp) {
        /**
         * 当 x = len(c) - 1 时，代表所有位已固定（最后一位只有1种情况），则将当前组合 c 转化为字符串并加入 res ，并返回；
         */
        if (pos == chars.length) {
            temp.add(String.valueOf(chars));
        }

        for (int i = pos; i < chars.length; i++) {
            swap(chars, i, pos);
            permutationSort(chars, pos + 1, temp);
            swap(chars, i, pos);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        TreeSet<String> result = new TreeSet<>();
        permutationSort(str.toCharArray(), 0, result);
        System.out.println(result);
    }
}
