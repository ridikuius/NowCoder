package leetcode.Tree;

/**
 * Created by RI01796 on 2016/8/1.
 */
public class isBalanceTree {

    private boolean isBalance=true;
    public boolean isBalanced(TreeNode root) {

        getDepth(root);
        return isBalance;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);

        if(Math.abs(left-right)>1){
            isBalance=false;
        }
        return right>left ?right+1:left+1;

    }
}
