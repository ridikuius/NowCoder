package leetcode.Dynamic;

import java.util.ArrayList;

/**
 * Created by RI01796 on 2016/8/25.
 */
public class RestoreIpAddresses {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();

        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        tool(result, list, s, 0);
        return result;
    }

    public void tool(ArrayList<String> result, ArrayList<String> list, String s, int start) {
        if (list.size() == 4) {
            if (start != s.length()) {
                return;
            }

            StringBuffer sb = new StringBuffer();
            for (String temp : list) {
                sb.append(temp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < s.length() && i < start + 3; i++) {
            String temp = s.substring(start, i + 1);
            if (valid(temp)) {
                list.add(temp);
                tool(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean valid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0"); // to eliminate cases like "00", "10"
        }
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}