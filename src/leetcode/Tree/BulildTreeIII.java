package leetcode.Tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出中序遍历和后续遍历结果构造二叉树
 * Created by RI01796 on 2016/8/10.
 */
public class BulildTreeIII {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return _bulid(inorder, 0, postorder, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode _bulid(int[] inorder, int start, int[] postorder, int end, int rstart,
                           int index) {

        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int r = 0;

        for (int i = start; i <= end; i++) {
            if (root.val == inorder[i]) {
                r = i;
                break;
            }
        }
        root.left = _bulid(inorder, start, postorder, r - 1, rstart, rstart + r - start - 1);
        root.right = _bulid(inorder, r + 1, postorder, end, rstart + r - start, index - 1);
        return root;
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }

    TreeNode Deserialize(String str) {
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = reconPreOrder(queue);
        root.right = reconPreOrder(queue);
        return root;
    }

    public static void main(String[] args) {
        int array3[] = new int[]{5, 3, 2, 6, 7, 1};
        int array1[] = new int[]{2, 3, 6, 5, 7, 1};
        int array2[] = new int[]{2, 6, 3, 1, 7, 5};
        BulildTreeIII buildTree = new BulildTreeIII();
        System.out.println(buildTree.Serialize(buildTree.buildTree(array1, array2)));
    }

}
