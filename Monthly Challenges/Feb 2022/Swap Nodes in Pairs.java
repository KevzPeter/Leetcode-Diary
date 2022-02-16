//16-02-2022
class ListNode {
    ListNode next;
    int val;

    ListNode(int _val) {
        val = _val;
        next = null;
    }
}

class Solution {
    public ListNode swapNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode newHead = head.next;
        while (curr != null && curr.next != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
            if (curr != null && curr.next != null)
                temp.next = curr.next;
        }
        return newHead;
    }
}