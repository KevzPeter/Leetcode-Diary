import java.util.Stack;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Stack<Integer> n1 = new Stack();
        Stack<Integer> n2 = new Stack();
        ListNode temp = l1;
        while (temp != null) {
            n1.push(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            n2.push(temp.val);
            temp = temp.next;
        }
        int carry = 0;
        Stack<Integer> total = new Stack();
        while (!n1.isEmpty() || !n2.isEmpty()) {
            int sum = (n1.isEmpty() ? 0 : n1.pop()) + (n2.isEmpty() ? 0 : n2.pop());
            total.push((sum % 10 + carry) % 10);
            carry = (sum + carry) / 10;
        }
        if (carry != 0) {
            total.push(carry);
        }
        ListNode dummy = new ListNode(0);
        temp = dummy;
        while (!total.isEmpty()) {
            temp.next = new ListNode(total.pop());
            temp = temp.next;
        }
        return dummy.next;
    }
}