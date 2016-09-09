package leetcode.Tree;

/**
 * Created by RI01796 on 2016/8/10.
 */
public class BuildTreeII {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return _build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode _build(int[] preorder, int index, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        if (start == end) {
            return root;
        }
        int r = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[index]) {
                r = i;
                break;
            }
        }
        root.left = _build(preorder, index + 1, inorder, start, r - 1);
        root.right = _build(preorder, index + r - start + 1, inorder, r + 1, end);
        return root;
    }
}
