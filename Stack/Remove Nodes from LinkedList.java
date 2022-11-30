// Solution using Monotonic stack
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            int val = temp.val;
            while (!stack.isEmpty() && stack.peek() < val)
                stack.pop();
            stack.push(val);
            temp = temp.next;
        }
        temp = new ListNode();
        head = temp;
        for (Integer i : stack) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }
}