package chenqx.leetcode;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/8 21:04
 *
 **/
public class Solution_1143 {
    //最长子字符串
//    public String longestCommonSubstring(String a, String b) {
//        int m = a.length(), n = b.length();
//        int[][] f = new int[m + 1][n + 1];
//        int max = 0, end = 0;                      // end: 最优子串在 a 中的结束位置
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (a.charAt(i - 1) == b.charAt(j - 1)) {
//                    f[i][j] = f[i - 1][j - 1] + 1;
//                    if (f[i][j] > max) { max = f[i][j]; end = i; }
//                }
//                // 不等时保持 0,new int[][] 已默认置零
//            }
//        }
//        return a.substring(end - max, end);
//    }

    //最长子序列
    public int longestCommonSubstring(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] f = new int[m + 1][n + 1];
        int max = 0, end = 0;                      // end: 最优子串在 a 中的结束位置
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = a.charAt(i - 1) == b.charAt(j - 1) ? f[i - 1][j - 1] + 1 : Math.max(f[i][j - 1], f[i - 1][j]);

            }
            // 不等时保持 0,new int[][] 已默认置零
        }
        return f[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1143().longestCommonSubstring("abc", "aabc"));
    }
}
