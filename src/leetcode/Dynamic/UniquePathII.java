package leetcode.Dynamic;

/**
 * Created by RI01796 on 2016/8/31.
 */
public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int con = obstacleGrid.length;
        int row = obstacleGrid[0].length;
        int[][] res = new int[con][row];

        for (int i = 0; i < con; i++) {
            if (obstacleGrid[i][0] != 1) {
                res[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (obstacleGrid[0][i] != 1) {
                res[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < con; i++) {
            for (int j = 1; j < row; j++) {
                if (obstacleGrid[i][j] != 1) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                } else {
                    res[i][j] = 0;
                }
            }
        }

        return res[con - 1][row - 1];
    }
}
