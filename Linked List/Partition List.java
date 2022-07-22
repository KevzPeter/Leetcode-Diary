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
    public ListNode partition(ListNode head, int x) {
        if (head == null || x < -200 || x > 200)
            return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode temp1 = dummy1;
        ListNode temp2 = dummy2;
        ListNode iter = head;
        while (iter != null) {
            if (iter.val < x) {
                temp1.next = new ListNode(iter.val);
                temp1 = temp1.next;
            } else {
                temp2.next = new ListNode(iter.val);
                temp2 = temp2.next;
            }
            iter = iter.next;
        }
        temp1.next = dummy2.next;
        temp2.next = null;
        return dummy1.next;
    }
}