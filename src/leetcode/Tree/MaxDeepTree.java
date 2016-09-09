package leetcode.Tree;

/**
 * Created by RI01796 on 2016/8/10.
 */
public class MaxDeepTree {
    public  int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }

}
