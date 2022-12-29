import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private class Task {
        int index;
        int enqueueTime;
        int processingTime;

        Task(int i, int e, int p) {
            index = i;
            enqueueTime = e;
            processingTime = p;
        }
    }

    public int[] getOrder(int[][] tasks) {
        if (tasks == null || tasks.length == 0)
            return new int[0];
        int n = tasks.length;
        Task[] t = new Task[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        int[] res = new int[n];
        Arrays.sort(t, (a, b) -> (a.enqueueTime - b.enqueueTime));
        int currTime = t[0].enqueueTime;

        PriorityQueue<Task> pq = new PriorityQueue<>((a,
                b) -> (a.processingTime == b.processingTime ? a.index - b.index : a.processingTime - b.processingTime));

        int i = 0, idx = 0;
        while (i < n) {
            while (i < n && t[i].enqueueTime <= currTime) {
                pq.offer(t[i]);
                i++;
            }
            if (pq.size() == 0) {
                currTime = t[i].enqueueTime;
            } else {
                res[idx++] = pq.peek().index;
                currTime += pq.poll().processingTime;
            }
        }
        while (!pq.isEmpty()) {
            res[idx++] = pq.poll().index;
        }
        return res;
    }
}