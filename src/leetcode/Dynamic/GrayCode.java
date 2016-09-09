package leetcode.Dynamic;

import java.util.*;

/**
 * Created by RI01796 on 2016/9/2.
 */
public class GrayCode {

   /* public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++) {
                res.add(i);
            }
            return res;
        }
        res = grayCode(n - 1);
        ArrayList<Integer> r1 = reverse(res);
        int x = 1 << (n - 1);
        for (int i = 0; i < r1.size(); i++) {
            r1.set(i, r1.get(i) + x);
        }
        res.addAll(r1);
        return res;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> r) {
        ArrayList<Integer> rev = new ArrayList<Integer>();
        for (int i = r.size() - 1; i >= 0; i--) {
            rev.add(r.get(i));
        }
        return rev;

    }*/

    public ArrayList<Integer> grayCode(int n) {
        if (n < 0) return null;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int temp = 1 << i;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(temp | res.get(j));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int i = 3;
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(i));
    }

}
