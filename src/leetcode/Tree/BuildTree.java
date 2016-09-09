package leetcode.Tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给出中序遍历和后续遍历结果构造二叉树
 *
 * Created by RI01796 on 2016/8/10.
 */

public class BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        List<Integer> inorder_list = new ArrayList<>();
        List<Integer> postorder_list = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            inorder_list.add(inorder[i]);
            postorder_list.add(postorder[i]);
        }
        return tool(inorder_list, postorder_list);
    }

    private TreeNode tool(List<Integer> inorder, List<Integer> postorder) {
        TreeNode root = new TreeNode(postorder.get(postorder.size() - 1));
        List<Integer> inorder_left = inorder.subList(0, inorder.indexOf(root.val));
        List<Integer>
                inorder_right =
                inorder.subList(inorder.indexOf(root.val) + 1, inorder.size());
        List<Integer> postorder_left = postorder.subList(0, inorder_left.size());
        List<Integer>
                postorder_right =
                postorder.subList(inorder_left.size(), postorder.size() - 1);
        if (inorder_left.size() > 1) {
            return tool(inorder_left, postorder_left);
        }
        if (inorder_right.size() > 1) {
            return tool(inorder_right, postorder_right);
        }
        if (inorder_left.size() == 1 && inorder_right.size() == 1) {
            root.left = new TreeNode(inorder_left.get(0));
            root.right = new TreeNode(inorder_right.get(0));
        }
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
        int array1[] = new int[]{2, 3, 6, 5, 7, 1};
        int array2[] = new int[]{2, 6, 3, 1, 7, 5};
        List<Integer> list1 = Lists.newArrayList(2, 3, 6, 5, 7, 1);
        List<Integer> list2 = Lists.newArrayList(2, 6, 3, 1, 7, 5);
        BuildTree buildTree = new BuildTree();
        System.out.println(buildTree.Serialize(buildTree.buildTree(array1, array2)));
    }
}
