/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode prev = null;
        for (ListNode ll : lists) {
            prev = mergeTwoLists(prev, ll);
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ans.next = l1;
                l1 = l1.next;
            } else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if (l1 == null)
            ans.next = l2;
        else
            ans.next = l1;
        return dummy.next;
    }
}