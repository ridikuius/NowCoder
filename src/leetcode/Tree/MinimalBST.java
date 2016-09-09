package leetcode.Tree;

import java.util.Arrays;

/**
 * Created by RI01796 on 2016/8/1.
 */
public class MinimalBST {

    public int buildMinimalBST(int[] vals) {
        if (vals.length <= 2) {
            return vals.length;
        }
        int len = vals.length;
        int left = buildMinimalBST(Arrays.copyOfRange(vals, 0, len / 2));
        int right = buildMinimalBST(Arrays.copyOfRange(vals, len / 2 + 1, len));
        return (left >= right) ? (left + 1) : (right + 1);
    }
}
