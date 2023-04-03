package com.smile.algorithm;

import java.util.*;

/**
 * 对key进行排序
 * @Description
 * @ClassName EctopicWordsGroup
 * @Author smile
 * @date 2021.12.05 11:22
 */
public class EctopicWordsGroup {

    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(arr);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = result.get(key);
            if (null == list) {
                list = new ArrayList<>();
                result.put(key, list);
            }
            list.add(str);
        }
        return new ArrayList<>(result.values());
    }
}
