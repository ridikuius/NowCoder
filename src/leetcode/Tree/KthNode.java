package leetcode.Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by RI01796 on 2016/8/1.
 */
public class KthNode {

    private static List<TreeNode> list = new ArrayList<>();

    static TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot == null || k == 0) {
            return null;
        }
        List<TreeNode> res = theInOrderTraversal(pRoot);
        if (k > res.size()) {
            return null;
        }
        return res.get(k - 1);

    }

    public static List<TreeNode> theInOrderTraversal(TreeNode root) {
        if (root.left != null) {
            theInOrderTraversal(root.left);
        }
        list.add(root);
        if (root.right != null) {
            theInOrderTraversal(root.right);
        }

        return list;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        System.out.println(KthNode(root, 10));
        //System.out.println(theInOrderTraversal(root));
    }
}
