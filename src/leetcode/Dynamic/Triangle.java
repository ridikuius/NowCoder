package leetcode.Dynamic;

import java.util.ArrayList;

/**
 *
 * Created by RI01796 on 2016/8/31.
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        if (triangle.get(0) == null || triangle.get(0).size()== 0) {
            return -1;
        }

        int n = triangle.size();
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            res[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[i][j] = Math.min(res[i + 1][j], res[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return res[0][0];
    }
}
