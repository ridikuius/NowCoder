package leetcode.Tree;

/**
 * Created by RI01796 on 2016/7/29.
 * 1.确保剩石头数>4
 * 2.如果剩下5个，本轮删除1个；如果剩下6个，本轮删除2个；如果剩下7个，本轮删除3个；其余每次删除1个
 */
public class Nim_Game {

    public static boolean canWinNim(int n) {
        return n % 4 != 0;

    }


    public static void main(String[] args) {
        System.out.println(canWinNim(8));
    }
}


