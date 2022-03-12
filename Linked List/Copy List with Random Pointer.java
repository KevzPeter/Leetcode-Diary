/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // TC : O(n)
    // SC : O(1)
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            Node copy = new Node(temp.val);
            copy.next = next;
            temp.next = copy;
            temp = next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node dummy = new Node(0);
        Node copy, copyTemp = dummy;
        while (temp != null) {
            Node next = temp.next.next;
            copy = temp.next;
            copyTemp.next = copy;
            copyTemp = copy;
            temp.next = next;
            temp = next;
        }
        return dummy.next;
    }

    // TC : O(n)
    // SC : O(n)
    public Node copyRandomList2(Node head) {
        if (head == null)
            return head;
        Node temp = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (temp != null) {
            Node curr = new Node(temp.val);
            map.put(temp, curr);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}