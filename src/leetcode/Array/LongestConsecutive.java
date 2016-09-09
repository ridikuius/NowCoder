package leetcode.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 只遍历一遍实现
 * Created by RI01796 on 2016/8/22.
 */
public class LongestConsecutive {

    public int longestConsecutive2(int[] num) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }
        int len = 0;
        for (int i = 0; i < num.length; i++) {
            if (set.contains(num[i])) {
                int next = num[i] - 1; // 找比num[i]小一个的值
                int cnt = 1;
                set.remove(num[i]); // 及时的移除，减少之后的查找时间
                while (set.contains(next)) {
                    set.remove(next);
                    next--;
                    cnt++;
                }
                next = num[i] + 1; // 找比num[i]大一个的值
                while (set.contains(next)) {
                    set.remove(next);
                    next++;
                    cnt++;
                }
                len = Math.max(len, cnt);
            }
        }
        return len;

    }

    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int cur : num) {
            set.add(cur);
        }
        int length = 0;
        for (int cur : num) {
            int down = cur - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = cur + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            length = Math.max(length, up - down - 1);
        }

        return length;
    }
}
