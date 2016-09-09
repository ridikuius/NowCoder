package leetcode.Tree;

import java.util.ArrayList;

/**
 * Created by RI01796 on 2016/8/2.
 */

public class preorderTraversalTree {

    private ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        res.add(root.val);
        if (root.left != null) {
            left = preorderTraversal(root.left);
        }
        if (root.right != null) {
            right = preorderTraversal(root.right);
        }
        if (left != null) {
            res.addAll(left);
        }
        if (right != null) {
            res.addAll(right);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
    }
}
