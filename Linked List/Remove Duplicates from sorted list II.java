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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int check = -1;
        while (head != null) {
            if (head.next != null && head.next.val != head.val) {
                temp.next = head;
                temp = temp.next;
            } else if (head.next != null && head.next.val == head.val) {
                check = head.val;
                while (head.next != null && head.next.val == check)
                    head = head.next;
            } else {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return dummy.next;
    }
}
