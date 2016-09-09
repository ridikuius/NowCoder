package leetcode.Tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by RI01796 on 2016/8/10.
 */
public class TreeSumPath {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        find(paths, new ArrayList<Integer>(), root, sum);
        return paths;
    }

    public void find(List<List<Integer>> paths, List<Integer> path, TreeNode root,
                     int target) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> path2 = new ArrayList<>();
        path2.addAll(path);
        if (root.left != null) {
            find(paths, path, root.left, target - root.val);
        }
        if (root.right != null) {
            find(paths, path2, root.right, target - root.val);
        }
    }

    /*   private ArrayList<Integer> getPath(TreeNode root) {
           ArrayList<Integer> path = new ArrayList<>();
           if (root == null) {
               return null;
           }
           if (root.left != null) {
               getPath(root.left);
               path.add(root.left.val);
           }
           if (root.right != null) {
               getPath(root.right);

           }
           if ()
           return ;
       }
   */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        TreeSumPath maxPathSum = new TreeSumPath();
        System.out.println(maxPathSum.pathSum(root, 13));
    }
}
