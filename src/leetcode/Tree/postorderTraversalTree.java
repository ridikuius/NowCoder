package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RI01796 on 2016/8/2.
 */
public class postorderTraversalTree {

    private static ArrayList<Integer> res = new ArrayList<>();

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            postorderTraversal(root.left);
        }
        if (root.left == null && root.right != null) {
            postorderTraversal(root.right);
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        return res;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> left =  new ArrayList<>();
        ArrayList<Integer> right =  new ArrayList<>();

        if (root.left != null) {
            left = postorderTraversal(root.left);
        }
        if (root.right != null) {
            right = postorderTraversal(root.right);
        }
        if (left != null) {
            res.addAll(left);
        }
        if (right != null) {
            res.addAll(right);
        }
        res.add(root.val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        System.out.println(postorderTraversal2(root));
    }
}
