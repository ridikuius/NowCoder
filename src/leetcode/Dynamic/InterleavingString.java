package leetcode.Dynamic;

/**
 * Created by RI01796 on 2016/9/1.
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int col = s1.length();
        int row = s2.length();
        boolean[][] res = new boolean[col + 1][row + 1];
        res[0][0] = true;

        for (int i = 1; i <= col; i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && res[i - 1][0]) {
                res[i][0] = true;
            }
        }

        for (int i = 1; i <= row; i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1) && res[0][i - 1]) {
                res[0][i] = true;
            }
        }

        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= row; j++) {
                if (((s3.charAt(i + j - 1) == s1.charAt(i - 1) && res[i - 1][j]))
                    || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && res[i][j - 1])) {
                    res[i][j] = true;
                }
            }
        }

        return res[col][row];
    }
}
