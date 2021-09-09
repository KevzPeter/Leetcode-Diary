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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int count=0;
        ListNode curr=head, ans=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        if(count==n)
            return head.next;
        int i=0;
        while(i!=count-n-1){
            head=head.next;
            i++;
        }
        head.next=head.next.next;
        return ans;
    }
}