/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int rotations = k % count;
        int currCount = 0;
        temp = head;
        ListNode newHead = new ListNode(0);
        
        while(temp!=null){
            currCount++;
            if(count - currCount == rotations){
                newHead.next = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;    
        }
        ListNode temp2 = newHead;
        while(temp2.next!=null){
            temp2 = temp2.next;
        }
        temp2.next = head;
        return newHead.next;
    }
}