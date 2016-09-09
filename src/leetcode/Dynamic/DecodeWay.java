package leetcode.Dynamic;

/**
 * Created by RI01796 on 2016/9/1.
 */
public class DecodeWay {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        res[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                res[i] = res[i - 1];
            }

            int nums = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (nums >= 10 && nums <= 26) {
                res[i] += res[i - 2];
            }
        }
        return res[s.length()];
    }

    public static void main(String[] args) {
        String s = "12";
        DecodeWay decodeWay = new DecodeWay();
        System.out.println(decodeWay.numDecodings(s));
    }
}
