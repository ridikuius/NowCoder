package leetcode.Tree;

/**
 * Created by RI01796 on 2016/8/1.
 */
public class TreeHight {

    public int TreeDepth(TreeNode pRoot) {
        {
            if (pRoot == null) {
                return 0;
            }
            return Math.max(TreeDepth(pRoot.left), TreeDepth(pRoot.right)) + 1;
        }
    }
}
