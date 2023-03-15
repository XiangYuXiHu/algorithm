package com.smile.algorithm;

/**
 * 最长回文子串
 *
 * @Description
 * @ClassName LongestPalindrome
 * @Author smile
 * @date 2023.03.15 21:58
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int lenStr = s.length();
        int p, q;
        int len = 1;
        int maxLen = 0;
        int maxStart = 0;
        for (int i = 0; i < lenStr; i++) {
            p = i - 1;
            q = i + 1;

            while (p >= 0 && s.charAt(i) == s.charAt(p)) {
                p--;
                len++;
            }

            while (q < lenStr && s.charAt(i) == s.charAt(q)) {
                q++;
                len++;
            }

            while (p >= 0 && q < lenStr && s.charAt(p) == s.charAt(q)) {
                p--;
                q++;
                len += 2;
            }

            if (len > maxLen) {
                maxLen = len;
                maxStart = p;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
