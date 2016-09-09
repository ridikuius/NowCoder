package leetcode.Tree;


/**
 *
 * Created by RI01796 on 2016/7/29.
 */
public class Reverse_String {
    public static String reverseString(String s) {
        StringBuilder sb  = new StringBuilder();
        for (int i = s.length()-1;i>-1;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello World!"));
    }
}
