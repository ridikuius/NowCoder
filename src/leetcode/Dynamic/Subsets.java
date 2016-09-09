package leetcode.Dynamic;

import java.util.*;

/**
 * Created by RI01796 on 2016/9/1.
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = S.length;
        Arrays.sort(S);
        //一个集合里有N个元素(可以是数),则它所有子集的数目是2^N
        for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(S[j]);
                }
            }
            res.add(subset);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] S = new int[]{1, 2, 3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(S));
    }
}
