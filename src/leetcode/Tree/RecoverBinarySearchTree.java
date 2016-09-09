package leetcode.Tree;

/**
 * Created by RI01796 on 2016/8/25.
 */
public class RecoverBinarySearchTree {

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode last = new TreeNode(Integer.MIN_VALUE);

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (first == null && root.val < last.val) {
            first = last;
        }
        if (first != null && root.val < last.val) {
            second = root;
        }
        last = root;
        traverse(root.right);
    }

    private void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(1);
        RecoverBinarySearchTree searchTree = new RecoverBinarySearchTree();
        searchTree.recoverTree(root);
    }
}
