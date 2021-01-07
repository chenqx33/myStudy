package chenqx.leetcode;

import org.junit.Test;

/**
 * @author chenqx 2020-02-27
 * @instruction
 */
public class CodeTest5 {
    @Test
    public void should_51() {
        System.out.println(longestPalindrome("abcbe"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        int length = 0;
        if (s.length() == 1 || s.length() == 0) return s;
        for (int i = 0; i < chars.length; i++) {
            if (i == 1 && chars[i - 1] == chars[i]) {
                index = 0;
                length = 2;
            }
            if (i > 1) {
                if (chars[i - 1] == chars[i]) {
                    for (int j = 0; j < i; j++) {
                        if (chars[i - 1 - j] != chars[i + j]) {
                            if (length < j * 2) {
                                index = i - j;
                                length = j * 2;
                            }
                            break;
                        } else if (i + j == s.length() - 1 && length < j * 2) {
                            index = i - j - 1;
                            length = j * 2 + 2;
                        }
                        if (i - 1 - j == 0 && length < j * 2 + 1) {
                            index = i - j - 1;
                            length = j * 2 + 2;
                        }
                        if (i + j + 1 == s.length()) {
                            if (length < j * 2 + 2) {
                                index = i - j - 1;
                                length = j * 2 + 2;
                            }
                            break;
                        }
                    }
                }
                if (chars[i - 2] == chars[i]) {
                    for (int j = 0; j < i - 1 && i + j < s.length(); j++) {
                        if (chars[i - 2 - j] != chars[i + j]) {
                            if (length < (j - 1) * 2 + 3) {
                                index = i - (j - 1) - 2;
                                length = (j - 1) * 2 + 3;
                            }
                            break;
                        } else if (i + j == s.length() - 1 && length < j * 2 + 3) {
                            index = i - j - 2;
                            length = j * 2 + 3;
                        }
                        if (i - 2 - j == 0 && length < j * 2 + 3) {
                            index = i - j - 2;
                            length = j * 2 + 3;
                        }
                    }
                }
            }

        }
        if (index == 0 && length == 0) return s.substring(0, 1);
        return s.substring(index, index + length);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    @Test
    public void should_52(){
        longestPalindrome1("abc");
    }
}
