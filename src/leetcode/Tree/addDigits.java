package leetcode.Tree;

/**
 * Created by RI01796 on 2016/7/29.
 */
public class addDigits {

    public static int addDigits(int num) {

        if (num < 10) {
            return num;
        } else {
            int temp = 0;
            String str = "" + num;
            for (int i = 0; i < str.length() ; i++) {
                int index = Integer.parseInt(String.valueOf(str.charAt(i)));
                temp = temp+index;
            }
            return addDigits(temp);
        }

    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
