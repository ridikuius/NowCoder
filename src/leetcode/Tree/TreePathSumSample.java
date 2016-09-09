package leetcode.Tree;

/**
 * Created by RI01796 on 2016/8/10.
 */
public class TreePathSumSample {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null || sum == 0) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                return true;
            }
        }
        if (hasPathSum(root.left, sum - root.val)) {
            return true;
        }
        if (hasPathSum(root.right, sum - root.val)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        TreePathSumSample hasPathSum = new TreePathSumSample();
        System.out.println(hasPathSum.hasPathSum(root, 13));
    }
}
