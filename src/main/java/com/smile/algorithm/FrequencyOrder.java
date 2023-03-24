package com.smile.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * @Description
 * @ClassName FrequencyOrder
 * @Author smile
 * @date 2023.03.25 07:03
 */
public class FrequencyOrder {

    public static void main(String[] args) {
        String freqOrder = freqOrder("tree");
        System.out.println(freqOrder);
    }

    public static String freqOrder(String str) {
        if (StringUtils.isBlank(str)) {
            return StringUtils.EMPTY;
        }
        Map<Character, Integer> characterCount = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
            int count = characterCount.getOrDefault(ch, 0) + 1;
            characterCount.put(ch, count);
        }
        ArrayList<Character> characters = new ArrayList<>(characterCount.keySet());
        Collections.sort(characters, (key1, key2) -> characterCount.get(key2).compareTo(characterCount.get(key1)));
        StringBuilder builder = new StringBuilder();
        for (Character ch : characters) {
            Integer freq = characterCount.get(ch);
            for (int i = 0; i < freq; i++) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
