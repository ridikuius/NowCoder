package leetcode.Dynamic;

/**
 * Created by RI01796 on 2016/8/31.
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int step1 = 1;
        int step2 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = step1 + step2;
            step2 = step1;
            step1 = res;
        }
        return res;
    }
}
