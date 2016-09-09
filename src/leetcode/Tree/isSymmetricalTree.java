package leetcode.Tree;

/**
 * 判断一个二叉树是不是镜像的
 *
 *
 * Created by RI01796 on 2016/8/1.
 */
public class isSymmetricalTree {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return contrast(pRoot.left, pRoot.right);
    }

    private boolean contrast(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return contrast(left.left, right.right) && contrast(left.right, right.left);
    }
}
