package leetcode.Recursion;

/**
 * Created by RI01796 on 2016/8/22.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if (s == null || s.equals("")) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            if (isChar(s, start)) {
                start++;
                continue;
            }
            if (isChar(s, end)) {
                end--;
                continue;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isChar(String s, int index) {
        char cur = s.charAt(index);
        return !(96 < cur && cur < 123) && !(47 < cur && cur < 58);
    }


    public static void main(String[] args) {
        String s = "race a car";
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome(s));
    }
}
