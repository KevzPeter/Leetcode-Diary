import java.util.*;
import java.util.PriorityQueue;
import java.util.logging.Logger;

class Node {
    private int vertex;
    private int weight;

    Node(int v, int w) {
        vertex = v;
        weight = w;
    }

    int getVertex() {
        return this.vertex;
    }

    int getWeight() {
        return this.weight;
    }
}

public class Dijkstra {
    private static final Logger LOGGER = Logger.getLogger(Dijkstra.class.getName());

    public static void main(String[] args) {
        int[][] edges = { { 0, 1, 1 }, { 0, 2, 2 }, { 0, 3, 4 }, { 2, 3, 1 }, { 3, 4, 2 } };
        int n = 5;
        Map<Integer, List<Node>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(new Node(b, c));
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(new Node(a, c));
        }
        Dijkstra obj = new Dijkstra();
        obj.getShortestPath(0, adj, n); // 0 is source
    }

    void getShortestPath(int s, Map<Integer, List<Node>> adj, int n) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.getWeight() - b.getWeight());
        pq.offer(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (!adj.containsKey(node.getVertex())) {
                continue;
            }
            for (Node neighbor : adj.get(node.getVertex())) {
                if (dist[node.getVertex()] + neighbor.getWeight() < dist[neighbor.getVertex()]) {
                    dist[neighbor.getVertex()] = dist[node.getVertex()] + neighbor.getWeight();
                    pq.offer(new Node(neighbor.getVertex(), dist[neighbor.getVertex()]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            LOGGER.info("Distance to destination " + i + " : " + dist[i]);
        }
    }
}
