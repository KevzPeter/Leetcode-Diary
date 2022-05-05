/*
One queue solution
TC : Push -> O(N); Pop -> O(1)
*/
class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue.add(x);
        int sz = queue.size();
        while (sz > 1) {
            queue.add(queue.poll());
            sz--;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
/*
 * Two queue solution
 * TC : Push -> O(N); Pop -> O(1)
 */
class MyStack {
    private int top;
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        top = x;
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            top = q1.poll();
            q2.offer(top);
        }

        int pop = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return pop;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}