package tutorials.leetcode;

import java.util.*;

public class ReverseNodesInkGroup {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(6))))));
        reverseKGroup(node, 3);
    }

    private static ListNode reverseKGroup(ListNode node, int k) {

        Deque<ListNode> holder = new LinkedList<>();
        ListNode lastNode = extracted(node, k, holder);
        ListNode prev = null;
        ListNode current = holder.pollLast();

        //доделать этот кусок
        while (!holder.isEmpty()) {
            ListNode next = holder.pollLast();
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static ListNode extracted(ListNode node, int k, Queue<ListNode> holder) {
        ListNode lastnode = getNext(node);
        for (int i = 1; i <= k; i++) {
            if (i == 1) {
                holder.add(node);
            } else {
                holder.add(lastnode);
                lastnode = getNext(lastnode);
            }
        }
        return lastnode;
    }

    private static ListNode getNext(ListNode node) {
        return node.next;
    }
}
