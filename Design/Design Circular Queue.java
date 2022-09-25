// daily challenge 9/25/22
class MyCircularQueue {
    int[] queue;
    int front, rear, size;

    public MyCircularQueue(int k) {
        queue = new int[k];
        size = k;
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        queue[front] = 0;
        if (front == rear) {
            front = rear = -1;
        } else
            front = (front + 1) % size;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1 || rear == front - 1);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */