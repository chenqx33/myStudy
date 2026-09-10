package chenqx.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 * @author chenqixin
 * @since 2026/9/8 21:39
 *
 **/
public class Solution_142 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode flow = head;
        ListNode dummy = null;
        while (fast != null) {
            flow = flow.next;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            if (flow == fast) {
                dummy = head;
                while (dummy != flow) {
                    dummy = dummy.next;
                    flow = flow.next;
                }
                return dummy;
            }

        }
        return dummy;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println(new Solution_142().detectCycle(listNode));
    }
}
