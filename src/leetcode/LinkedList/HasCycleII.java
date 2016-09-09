package leetcode.LinkedList;

/**
 * Created by RI01796 on 2016/8/18.
 */
public class HasCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode right = head;
        ListNode left = head;
        if (head == null) {
            return null;
        }
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            if (left == right) {
                left = head;
                while (left != right) {
                    left = left.next;
                    right = right.next;
                }
                return left;

            }
        }
        return null;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
       /* head.next.next = new ListNode(3);
        head.next.next.next = head.next;*/
        HasCycleII hasCycleII = new HasCycleII();
        System.out.println(hasCycleII.detectCycle(head));
      /*  System.out.println(hasCycleII.detectCycle(head).next.val);
        System.out.println(hasCycleII.detectCycle(head).next.next.val);*/
    }

}
