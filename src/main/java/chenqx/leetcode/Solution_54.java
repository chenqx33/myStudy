package chenqx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/9 17:41
 *
 **/
public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int[] times = {m, n};

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = -1, pos = 0;

        while (result.size() < m * n) {
            for (int i = 0; i < times[(pos + 1) % 2]; i++) {
                x += dx[pos];
                y += dy[pos];
                result.add(matrix[x][y]);
            }
            times[pos % 2] = times[pos % 2] - 1;
            pos = (pos + 1) % 4;
        }
        return result;

    }
}
