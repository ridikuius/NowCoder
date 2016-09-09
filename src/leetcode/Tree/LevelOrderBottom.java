package leetcode.Tree;

import java.util.ArrayList;
import java.util.*;

/**
 * 层级遍历二叉树，从最底层返回数组
 * Created by RI01796 on 2016/8/10.
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        int cur = 0;
        int last = 1;
        while (cur < list.size()) {
            ArrayList<Integer> lev = new ArrayList<>();
            last = list.size();
            while (cur < last) {
                lev.add(list.get(cur).val);
                if (list.get(cur).left != null) {
                    list.add(list.get(cur).left);
                }
                if (list.get(cur).right != null) {
                    list.add(list.get(cur).right);
                }
                cur++;
            }
            res.add(lev);
        }
        return res;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(1);
        LevelOrderBottom maxPathSum = new LevelOrderBottom();
        System.out.println(maxPathSum.levelOrderBottom(root));
    }
}
