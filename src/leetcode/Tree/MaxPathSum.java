package leetcode.Tree;

/**
 * 寻找树的最大路径
 * Created by RI01796 on 2016/8/10.
 */
public class MaxPathSum {

    int sum;
    public  int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        sum = Integer.MIN_VALUE;
        maxPath(root);
        return sum;
    }
    private int maxPath(TreeNode root){
        if(root==null)
            return 0;
        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));
        sum = Math.max(sum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
       /* root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);*/
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(root));
    }
}
