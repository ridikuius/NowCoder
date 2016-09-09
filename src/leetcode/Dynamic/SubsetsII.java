package leetcode.Dynamic;

import java.util.*;
import java.util.Arrays;

/**
 * Created by RI01796 on 2016/9/1.
 */
public class SubsetsII {

   /* public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<Integer>();
        subset(res, list, num, 0);
        return res;
    }

    public void subset(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
                       int[] num, int pos) {
        res.add(new ArrayList(list));
        for (int i = pos; i < num.length; i++) {
            if (i != pos && num[i] == num[i - 1]) {
                continue;
            }

            list.add(num[i]);
            subset(res, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }*/

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        subset(res, list, nums, 0);
        return res;
    }

    public void subset(List<List<Integer>> res, List<Integer> list,
                       int[] num, int pos) {
        res.add(new ArrayList(list));
        for (int i = pos; i < num.length; i++) {
            if (i != pos && num[i] == num[i - 1]) {
                continue;
            }

            list.add(num[i]);
            subset(res, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] S = new int[]{1, 2, 2};
        SubsetsII subsets = new SubsetsII();
        System.out.println(subsets.subsetsWithDup(S));
    }

}
