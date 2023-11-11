class Graph {
    private List<List<Pair<Integer, Integer>>> adj;
    private int n;

    private class EdgeComparator implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            return p1.getValue() - p2.getValue();
        }
    }

    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<List<Pair<Integer, Integer>>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair<Integer, Integer>>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        adj.get(u).add(new Pair(v, w));
    }

    public int shortestPath(int node1, int node2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(new EdgeComparator());

        pq.offer(new Pair(node1, 0));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> currentEdge = pq.poll();
            int currentNode = currentEdge.getKey();
            int currentWeight = currentEdge.getValue();
            if (map.containsKey(currentNode))
                continue;
            map.put(currentNode, currentWeight);

            for (Pair<Integer, Integer> p : adj.get(currentNode)) {
                int neighbor = p.getKey();
                int neighborWeight = p.getValue();
                if (!map.containsKey(neighbor)) {
                    pq.offer(new Pair(neighbor, currentWeight + neighborWeight));
                }
            }
        }
        if (!map.containsKey(node2))
            return -1;
        return map.get(node2);
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */