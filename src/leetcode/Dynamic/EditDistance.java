package leetcode.Dynamic;

/**
 * Created by RI01796 on 2016/8/31.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int con = word1.length();
        int row = word2.length();
        int[][] res = new int[con + 1][row + 1];
        for (int i = 0; i < row + 1; i++) {
            res[0][i] = i;
        }
        for (int i = 0; i < con + 1; i++) {
            res[i][0] = i;
        }

        for (int i = 1; i < con + 1; i++) {
            for (int j = 1; j < row + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] =
                            1 + Math.min(res[i - 1][j - 1], Math.min(res[i - 1][j], res[i][j - 1]));
                }
            }
        }
        return res[con][row];
    }
}
