package leetcode.Tree;


import java.util.ArrayList;

/**
 *
 *
 * Created by RI01796 on 2016/8/1.
 */
public class TreeSum {


    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int num) {

        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return paths;
        }
        find(paths, new ArrayList<Integer>(), root, num);
        return paths;
    }

    private void find(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root,
                      int num) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (num == root.val) {
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> path2 = new ArrayList<>();
        path2.addAll(path);
        if (root.left != null) {
            find(paths, path, root.left, num - root.val);
        }
        if (root.right != null) {
            find(paths, path2, root.right, num - root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        TreeSum maxPathSum = new TreeSum();
        System.out.println(maxPathSum.pathSum(root, 13));
    }
}

