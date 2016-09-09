package leetcode.Tree;

/**
 * 中序遍历（左根右）
 * 如果当前节点是根节点，那么输出该节点的右节点
 *
 * Created by RI01796 on 2016/8/1.
 */
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode == pNode.next.left) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;

    }
}
