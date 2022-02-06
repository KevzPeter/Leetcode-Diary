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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null)
            return null;
        ListNode curr=head, prev=null, next=null;
        int count=0;
        while(count<k){
            if(curr==null)
                return head;
            curr=curr.next;
            count++;
        }
        curr=head;
        count=0;
        while(count<k && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if (next != null)
            head.next = reverseKGroup(next, k);
 
        return prev;
    }
}