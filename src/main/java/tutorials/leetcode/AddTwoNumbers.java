package tutorials.leetcode;

import java.util.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(
                2, new ListNode(
                4, new ListNode(3, null)));

        ListNode listNode1 = new ListNode(
                5, new ListNode(
                6, new ListNode(4, null)));


        addTwoNumbers(listNode, listNode1);
    }


    public static ListNode addTwoNumbers(ListNode listNode, ListNode listNode1) {
        LinkedList list = new LinkedList<Integer>();
        list.get(3);
        return new ListNode();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
