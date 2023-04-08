/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> map;

    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if (node == null)
            return node;
        return clone(node);
    }

    private Node clone(Node node) {
        if (map.containsKey(node.val))
            return map.get(node.val);
        Node copy = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, copy);
        for (Node neighbour : node.neighbors) {
            copy.neighbors.add(clone(neighbour));
        }
        return copy;
    }
}

// Another Solution

class Solution2 {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        HashMap<Node, List<Node>> neighbors = new HashMap<>();
        dfs(node, map, neighbors);
        for (Map.Entry<Node, List<Node>> e : neighbors.entrySet()) {
            Node originalNode = e.getKey();
            Node clonedNode = map.get(originalNode);
            List<Node> clonedNeighbors = new ArrayList<>();
            for (Node neighbor : e.getValue()) {
                clonedNeighbors.add(map.get(neighbor));
            }
            clonedNode.neighbors = clonedNeighbors;
        }
        return map.get(node);
    }

    private void dfs(Node node, HashMap<Node, Node> map, HashMap<Node, List<Node>> neighbors) {
        if (node == null)
            return;
        map.put(node, new Node(node.val));
        neighbors.put(node, new ArrayList<Node>());
        for (Node nei : node.neighbors) {
            neighbors.get(node).add(nei);
            if (!map.containsKey(nei)) {
                dfs(nei, map, neighbors);
            }
        }
    }
}