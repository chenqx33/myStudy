package chenqx.leetcode;

import java.util.*;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/10 15:22
 *
 **/
public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        char[] charArray = s.toCharArray();
        Map<Character, Integer> index = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, index.getOrDefault(charArray[i], 0));
            max = Math.max(i-start+1, max);
            index.put(charArray[i], i+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_3().lengthOfLongestSubstring("ccbbcc"));
    }
}
