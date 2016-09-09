package leetcode.Tree;

/**
 * 先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
 * Created by RI01796 on 2016/8/9.
 */
public class PathTotal {

    public  static int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        return addNum(root, sum);
    }

    public static int addNum(TreeNode root, int sum) {
        if (root==null){
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return addNum(root.left, sum) + addNum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
       /* root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);*/
        System.out.println(sumNumbers(root));
    }
}
