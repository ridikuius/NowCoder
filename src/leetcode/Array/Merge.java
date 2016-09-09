package leetcode.Array;

/**
 * Created by RI01796 on 2016/8/22.
 */
public class Merge {

    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null) {
            return;
        }
        int index = m + n - 1;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[index] = A[m - 1];
                m--;
            } else {
                A[index] = B[n - 1];
                n--;
            }
            index--;
        }

        while (n > 0) {
            A[index] = B[n - 1];
            n--;
            index--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9};
        int[] B = {2, 4, 6, 8, 10};
        Merge m = new Merge();
        m.merge(A, 5, B, 5);
    }
}
