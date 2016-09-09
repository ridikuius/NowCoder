package leetcode.LinkedList;

/**
 * Created by RI01796 on 2016/8/18.
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {

        ListNode right = head;
        ListNode left = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            if (left == right) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        HasCycle hasCycle = new HasCycle();
        System.out.println(hasCycle.hasCycle(head));
    }
}
