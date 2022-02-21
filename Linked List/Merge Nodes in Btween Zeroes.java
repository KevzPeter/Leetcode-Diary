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
    public ListNode mergeNodes(ListNode head) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        ListNode iter = head;
        while(iter!=null){
            if(iter.val == 0 && iter.next == null){
                temp.next = null;
            }
            else if(iter.val == 0){
                temp.next = new ListNode(0);
                temp = temp.next;
            }
            else{
                temp.val += iter.val;
            }
            iter = iter.next;
        }
        return dummy.next;
    }
}