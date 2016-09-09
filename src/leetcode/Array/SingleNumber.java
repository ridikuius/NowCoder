package leetcode.Array;

/**
 * 线性复杂度
 * 不使用额外内存
 * Created by RI01796 on 2016/8/18.
 */
public class SingleNumber {


    public int singleNumber(int[] A) {

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }
}
