import java.util.*;

class Node implements Comparator<Node> {
    int vertex;
    int weight;

    public Node(int v, int w) {
        vertex = v;
        weight = w;
    }

    Node() {
    };

    public int getVertex() {
        return this.vertex;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compare(Node n1, Node n2) {
        if (n1.weight < n2.weight)
            return -1;
        else if (n1.weight > n2.weight)
            return 1;
        else
            return 0;
    }
}

public class Dijkstra {
    public static void main(String args[]) {
        int N = 5;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        // create list here
        Dijkstra obj = new Dijkstra();
        obj.getShortestPath(0, adj, N); // 0 is source
    }

    void getShortestPath(int s, List<List<Node>> adj, int n) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        pq.offer(new Node(s, 0));
        while (pq.size() > 0) {
            Node node = pq.poll();
            for (Node it : adj.get(node.getVertex())) {
                if (dist[node.getVertex()] + it.getWeight() < dist[it.getVertex()]) {
                    dist[it.getVertex()] = dist[node.getVertex()] + it.getWeight();
                    pq.offer(new Node(it.getVertex(), dist[it.getVertex()]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Distance to destination " + i + " : " + dist[i]);
        }
    }
}
