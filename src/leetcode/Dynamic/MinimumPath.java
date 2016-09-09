package leetcode.Dynamic;

/**
 * Created by RI01796 on 2016/8/31.
 */
public class MinimumPath {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int con = grid.length;
        int row = grid[0].length;

        int[][] res = new int[con][row];
        res[0][0] = grid[0][0];

        for (int i = 1; i < con; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < con; i++) {
            for (int j = 1; j < row; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }

        return res[con - 1][row - 1];

    }
}
