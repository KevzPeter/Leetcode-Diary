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
        if(node == null) return node;
        return clone(node);
    }
    private Node clone(Node node){
        if(map.containsKey(node.val))
            return map.get(node.val);
        Node copy = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, copy);
        for(Node neighbour : node.neighbors){
            copy.neighbors.add(clone(neighbour));
        }
        return copy;
    }
}