package chenqx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/8 16:00
 *
 **/
public class Solution_435 {
    //    public int eraseOverlapIntervals(int[][] intervals) {
//
//        if (intervals.length ==0 ){
//            return 0;
//        }
//        Arrays.sort(intervals, (a, b) ->
//                a[1] != b[1] ? Integer.compare(a[1], b[1])
//                        : Integer.compare(b[0], a[0]));
//        int keep=1;
//        int end = intervals[0][1];
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][0]>=end){
//                keep++;
//                end = intervals[i][1];
//            }
//        }
//        return intervals.length - keep;
//    }
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(b[0], a[0]));
        int max=0;
        int[] f = new int[intervals.length];
        Arrays.fill(f, 1);

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][1]<=intervals[i][0]){
                    f[i] = Math.max(f[j]+1, f[i]);
                }
            }
        }
        return intervals.length - Arrays.stream(f).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(new Solution_435().eraseOverlapIntervals(intervals));
    }
}
