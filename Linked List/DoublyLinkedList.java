class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val; 
    }
}

public class DoublyLinkedList {
    Node head = new Node(0);
    Node tail = new Node(0);head.next=tail;tail.prev=head;head.prev=tail.next=null;

    boolean isEmpty() {
        return (head == null);
    }

    void insertFirst(int key, int val) {
        Node newNode = new Node(key, val);
        Node nextNode = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = nextNode;
    }

    void insertEnd(int key, int val) {
        Node newNode = new Node(key, val);
        Node lastNode = tail.prev;
        lastNode.next = newNode;
        newNode.prev = lastNode;
        newNode.next = tail;
    }

    void delete()

    void update(int key, int val) {
        Node temp = head;
        while (temp != null && temp.key != key)
            temp = temp.next;
        temp.val = val;
    }
}