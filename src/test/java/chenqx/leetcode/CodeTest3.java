package chenqx.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author chenqx 2020-02-26
 * @instruction
 */
public class CodeTest3 {
    @Test
    public void should_code3() {
        String s = "ohomm";
        int result = 0;
        List<Character> fu = new ArrayList<>();
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (fu.contains(s.charAt(i))) {
                result = result > fu.size() ? result : fu.size();
                fu = fu.subList(index.get(s.charAt(i)) + 1, fu.size());
                fu.add(s.charAt(i));
                index.put(s.charAt(i), i);
            } else {
                fu.add(s.charAt(i));
                index.put(s.charAt(i), i);
            }
            if (i == s.length() - 1) {
                result = result > fu.size() ? result : fu.size();
            }
        }
        System.out.println(result);
    }

    @Test
    public void should_code31() {
        String s = "ohomm";
        int result = 0;
        String fu = "";
        for (int i = 0; i < s.length(); i++) {
            if (fu.contains("" + s.charAt(i))) {
                result = result > fu.length() ? result : fu.length();
                int i1 = fu.indexOf("" + s.charAt(i));
                fu = fu.substring(i1+1);
                fu+=s.charAt(i);
            } else {
                fu += s.charAt(i);
            }
            if (i == s.length() - 1) {
                result = result > fu.length() ? result : fu.length();
            }
        }
        System.out.println(result);
    }

    @Test
    public void should_code32() {
        String s = "aab";
        int result = 0;
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (queue.contains(s.charAt(i))) {
                result = result > queue.size() ? result : queue.size();
                while (queue.poll()!=s.charAt(i)){}
                queue.add(s.charAt(i));
            } else {
                queue.add(s.charAt(i));
            }
            if (i == s.length() - 1) {
                result = result > queue.size() ? result : queue.size();
            }
        }
        System.out.println(result);
    }
    @Test
    public void should_code33() {
        String s = "aab";
        int maxSize = 0;
        int [] dict = new int[256]; //记录ASCII 码字符出现的位置，以字符作为下标
        int base = 0;
        int key = 0;
        int i=0;
        while(key < s.length()){
            i = s.charAt(key);
            if(dict[i] > base)
                base = dict[i];
            dict[i] = key+1; //以1作为起始位置，下标加1
            maxSize = (maxSize>key-base+1)?maxSize:key-base+1;
            key++;
        }
        System.out.println(maxSize);
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    @Test
    public void should_35(){
        lengthOfLongestSubstring1("abcaf");
    }
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
