class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

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

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(this.capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null)
            remove(map.get(key));
        if (map.size() == this.capacity)
            remove(tail.prev);
        insert(new Node(key, value));
    }

    public void remove(Node node) {
        map.remove(node.key);
        Node lastNode = node.prev;
        Node nextNode = node.next;
        lastNode.next = nextNode;
        nextNode.prev = lastNode;
    }

    public void insert(Node node) {
        map.put(node.key, node);
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */