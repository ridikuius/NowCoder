package leetcode.Tree;

/**
 * Created by RI01796 on 2016/7/29.
 */
public class getSum {

    public static int getSum(int a, int b) {
        int tmp = a, carry = b;
        int num;
        while (carry != 0) {
            num = tmp ^ carry;
            carry = (tmp & carry) << 1;
            tmp = num;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(getSum(6, 2));
    }
}
