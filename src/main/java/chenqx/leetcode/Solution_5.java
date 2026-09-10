package chenqx.leetcode;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/10 16:18
 *
 **/
public class Solution_5 {
    public String longestPalindrome(String s) {
        if (s.length()<2)return s;

        int n = s.length();

        int start = 0,end=0,maxlen=0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i+j>n-1) continue;
                if(s.charAt(i-j) == s.charAt(i+j)){

                    if (j*2+1>maxlen){
                        start = i-j;
                        end = i+j;
                    }
                    maxlen = Math.max(j*2+1,maxlen);
                }else break;
            }
            for (int j = 1; j <= i; j++) {
                if (i+j>n) continue;
                if(s.charAt(i-j) == s.charAt(i+j-1)){

                    if (j*2>maxlen){
                        start = i-j;
                        end = i+j-1;
                    }
                    maxlen = Math.max(j+1,maxlen);
                }else break;
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_5().longestPalindrome("tattarrattat"));
    }
}
