package leetcode.String;


/**
 * Created by RI01796 on 2016/9/2.
 */
public class ValidNum {

    public boolean isNumber(String s) {

        int len = s.length();
        int i = 0, e = len - 1;
        while (i <= e && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if (i > len - 1) {
            return false;
        }
        while (e >= i && Character.isWhitespace(s.charAt(e))) {
            e--;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while (i <= e) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) {
                    return false;
                }
                dot = true;
            } else if (c == 'e') {
                if (exp || num == false) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return num;

    }

    public static void main(String[] args) {
        String s = "1";
        ValidNum validNum = new ValidNum();
        System.out.println(validNum.isNumber(s));
    }
}
