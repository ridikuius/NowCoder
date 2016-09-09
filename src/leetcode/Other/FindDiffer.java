package leetcode.Other;

/**
 * Created by RI01796 on 2016/9/2.
 */
public class FindDiffer {

    public char findTheDifference(String s, String t) {
        int num_s = 0, num_t = t.charAt(t.length()-1);
        for (int i = 0; i < s.length(); i++) {
            num_s += s.charAt(i);
            num_t += t.charAt(i);

        }
        int res = num_t - num_s;
        return (char) res;
    }

    public static void main(String[] args) {
        String s = "asdfgh";
        String t = "asdfggh";
        FindDiffer findDiffer = new FindDiffer();
        System.out.println(findDiffer.findTheDifference(s, t));
    }

}
