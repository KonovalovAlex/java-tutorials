package tutorials.leetcode;

import java.util.Iterator;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        ListNode result = remove(listNode, 2);
        System.out.println(result);
    }

    private static ListNode remove(ListNode head, int n) {
        if (head.hasNext()) {
            if (head.next.val == n){
                if (head.next.hasNext()) {
                    head.next = head.next.next;
                }
            } else {
                remove(head.next, n);
            }

            return head;
        } else {
            return head;
        }
    }
}
