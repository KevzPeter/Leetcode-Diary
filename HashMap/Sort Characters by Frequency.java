class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[256];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0)
                pq.offer(new int[] { i, freq[i] });
        }

        while (!pq.isEmpty()) {
            char c = (char) pq.peek()[0];
            int rep = pq.peek()[1];
            while (rep > 0) {
                sb.append(c);
                rep--;
            }
            pq.poll();
        }

        return sb.toString();
    }
}