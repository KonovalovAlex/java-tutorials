package tutorials.leetcode;

import java.util.Iterator;

public class ListNode implements Iterator {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public ListNode next() {
        return next;
    }
}
