class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class LL {
    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int val) {
        if (isEmpty()) {
            Node node = new Node(val);
            node.next = head;
            head = node;
        } else {
            Node node = new Node(val);
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.next = null;
        }
    }

    public void deleteFirst() {
        if (isEmpty())
            return;
        Node temp = head;
        head = head.next;
        System.out.println("Deleted node val: " + temp.val);
    }

    public void deleteNode(int val) {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        if (temp.val == val) {
            head = temp.next;
            return;
        }
        Node prev = temp;
        while (temp != null && temp.val != val) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }

    public void insertAfter(int val, int newVal) {
        if (isEmpty()) {
            System.out.println("Linked list is empty, creating new head...");
            insert(newVal);
            return;
        }
        Node node = new Node(newVal);
        Node temp = head;
        while (temp != null && temp.val != val) {
            temp = temp.next;
        }
        Node nextNode = temp.next;
        temp.next = node;
        node.next = nextNode;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
}

public class LinkedList {
    public static void main(String args[]) {
        LL linkedlist = new LL();
        for (int i = 1; i <= 5; i++) {
            linkedlist.insert(i);
        }
        linkedlist.print();
        linkedlist.deleteFirst();
        linkedlist.print();
        for (int i = 2; i <= 5; i++) {
            linkedlist.deleteNode(i);
        }
        linkedlist.insertAfter(4, 7);
        linkedlist.print();
    }
}