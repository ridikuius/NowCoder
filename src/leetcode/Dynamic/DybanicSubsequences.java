package leetcode.Dynamic;

/**
 * Created by RI01796 on 2016/8/31.
 */
public class DybanicSubsequences {


    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int[][] res = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                res[i][j] = res[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    res[i][j] += res[i - 1][j - 1];
                }
            }
        }
        return res[S.length()][T.length()];
    }


    public static void main(String[] args) {
        String S = "rababbits";
        String T = "rabbits";
        DybanicSubsequences subsequences = new DybanicSubsequences();
        System.out.println(subsequences.numDistinct(S, T));
    }
}
