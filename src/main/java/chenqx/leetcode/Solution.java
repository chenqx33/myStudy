package chenqx.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/8 14:24
 *
 **/
public class Solution {
    static int m,n;
    Queue<int[]> queue = new LinkedList<int[]>();

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};


    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0]=='O'){
                queue.offer(new int[]{i,0});
                board[i][0] = 'A';
            }
            if (board[i][n-1]=='O'){
                queue.offer(new int[]{i,n-1});
                board[i][n-1] = 'A';
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i]=='O'){
                queue.offer(new int[]{0,i});
                board[0][i] = 'A';
            }
            if (board[m-1][i]=='O'){
                queue.offer(new int[]{m-1,i});
                board[m-1][i] = 'A';
            }
        }
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0],y = poll[1];
            for (int i = 0; i < 4; i++) {
                int mx=x+dx[i],my=y+dy[i];
                if (mx<0||mx>=m||my<0||my>=n||board[mx][my]!='O'){
                    continue;
                }
                queue.offer(new int[]{mx,my});
                board[mx][my] = 'A';

            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] =='A'){
                    board[i][j] = 'O';
                }

            }
        }

    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new Solution().solve(board);
        for (char[] row : board) {
            System.out.println(String.join(" ", new String(row).split("")));
        }

    }
}


//class Solution {
//    static int m,n;
//
//    public void solve(char[][] board) {
//        m = board.length;
//        if (m==0) return;
//        n = board[0].length;
//
//        for (int i = 0; i < m; i++) {
//            dfs(board, i, 0);
//            dfs(board, i, n-1);
//        }
//        for (int j = 0; j < n; j++) {
//            dfs(board, 0, j);
//            dfs(board, m-1, j);
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j] == 'O'){
//                    board[i][j] = 'X';
//                }
//                if (board[i][j] =='A'){
//                    board[i][j] = 'O';
//                }
//
//            }
//        }
//
//    }
//
//    static void dfs(char[][] board, int i, int j){
//        if (i<0||i>=m||j<0||j>=n|| board[i][j]!='O'){
//            return;
//        }
//        board[i][j] = 'A';
//
//        dfs(board,i,j+1);
//        dfs(board,i,j-1);
//        dfs(board,i+1,j);
//        dfs(board,i-1,j);
//    }
//}