package leetcode.Array;

/**
 * 异或： 相同为零，不同为1
 * Created by RI01796 on 2016/8/18.
 */
public class SingleNumberII {

    public int singleNumber1(int[] A) {
        int ones = 0;//记录只出现过1次的bits
        int twos = 0;//记录只出现过2次的bits
        int threes;
        for (int i = 0; i < A.length; i++) {
            int t = A[i];
            twos |= ones & t;//要在更新ones前面更新twos
            ones ^= t;
            threes = ones & twos;//ones和twos中都为1即出现了3次
            ones &= ~threes;//抹去出现了3次的bits
            twos &= ~threes;
        }
        return ones;
    }

    public int singleNumber2(int[] A) {

        //discuss.leetcode.com/topic/22821/an-general-way-to-handle-all-this-sort-of-questions/1

        //这里面有详解，这里主要说一下思想

        //因为出现的是三次，所以需要设计成一个数出现3次之后自动会变为0，这就代表不影响后面的数

        //现在只用bit来表示，a，b可能是0,1的组合，c(next bit)可能是0或者1

        //采用两位a,b来表示.  a ，b 的值可能为0 0 ，0 1 ，10

        //分别代表0次，1次，2次。不可能出现1 1。因为3次之后就清0了

        //当对应不同的数字时，无非就是把一位的情况扩展到了32位。但逻辑运算（对于每一位的仍然一样）

        int a = 0;

        int b = 0;

        int ta = 0;

        for (int c : A) {

            ta = (~a & b & c) | (a & ~b & ~c);  //这里之所以需要使用ta，是因为计算b的时候需要a的旧值

            b = (~a & ~b & c) | (~a & b & ~c);

            a = ta;

        }

        //we need find the number that is 01,10 => 1, 00 => 0.

        //return a|b 意思是返回出现一次或者出现两次的那个数(假设不知道一个数是出现了一次还是两次)

        //不管只有一个数出现了一次还是两次，另一个数一定为0；相或即可

        return a | b;

    }

    /* 把所有整数按照32位二进制进行每一位上的与1运算  结果为3n或3n+1
   为3n+1的那些位就是只出现一次的数的二进制中1所在的位
   */
    public int singleNumber3(int[] A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            //记录在i位上1的个数
            int count = 0;

            for (int j = 0; j < A.length; j++) {
                if ((A[j] >> i & 1) == 1) {
                    count++;
                }
            }
            //把3n+1的那些位的1移回原位并累加起来 |=  也行
            result += ((count % 3) << i);
        }

        return result;
    }

    public int singleNumber(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int result = 0, bit_i_sum = 0;
        for (int i = 0; i != 32; ++i) {
            bit_i_sum = 0;
            for (int j = 0; j != A.length; ++j) {
                bit_i_sum += ((A[j] >> i) & 1);
            }
            result |= ((bit_i_sum % 3) << i);
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();
        int[] A = new int[]{1, 2, 3, 1, 3, 2, 1, 4, 3, 2};
        System.out.println(singleNumberII.singleNumber(A));
    }
}
