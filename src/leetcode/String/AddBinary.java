package leetcode.String;

/**
 * Created by RI01796 on 2016/9/2.
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int a_len = a.length(), b_len = b.length();
        int car_bit = 0;
        for (int i = a_len - 1, j = b_len - 1; i >= 0 || j >= 0; i--, j--) {
            int a_num = (i < 0) ? 0 : a.charAt(i) - '0';
            int b_num = (j < 0) ? 0 : b.charAt(j) - '0';

            int num = (a_num + b_num + car_bit) % 2;
            car_bit = (a_num + b_num + car_bit) / 2;
            sb.append(num);
        }
        if (car_bit == 1) {
            sb.append(1);
        }
        sb.reverse();
        return sb.toString();
    }


    public String addBinary2(String a, String b) {
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }

        int pa = a.length()-1;
        int pb = b.length()-1;
        int carries = 0;
        String rst = "";

        while(pb >= 0){
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
            pb --;
        }

        while(pa >= 0){
            int sum = (int)(a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }

        if (carries == 1)
            rst = "1" + rst;
        return rst;
    }
}
