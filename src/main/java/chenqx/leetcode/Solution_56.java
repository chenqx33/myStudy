package chenqx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/9 16:09
 *
 **/
public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;

        List<int[]> merged = new ArrayList<int[]>();

        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];

            if (merged.size()==0 || merged.get(merged.size()-1)[1]<l){
                merged.add(new int[]{l,r});
            }else{
                merged.get(merged.size()-1)[1] = Math.max(r,merged.get(merged.size() - 1)[1]);
            }
        }


        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution_56 solution56 = new Solution_56();
        int[][] merge = solution56.merge(new int[][]{{1, 3}, {2, 6},{8,10},{15,18}});
        for (int[] row : merge) {
            System.out.println(Arrays.toString(row));   // [1, 5]
        }
    }
}
