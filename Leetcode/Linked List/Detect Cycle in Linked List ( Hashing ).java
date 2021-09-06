/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet <ListNode> s = new HashSet<>();
        
        
        while(head!=null){
            if(s.contains(head))
                return true;
            else 
                s.add(head);
            head=head.next;
        }
        return false;
    }
}