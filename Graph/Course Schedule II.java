class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack <Integer> stack = new Stack<>();
        boolean vis[] = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        adjacencyList(prerequisites, adj); //initialize adjacency list
        
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                topoSort(i, adj, vis, stack); 
            }
        }
        int res[] = new int[numCourses];
        Map<Integer, Integer> pos = new HashMap<>(); //for checking cycle
        int ind = 0;
        while (!stack.isEmpty()) {
            pos.put(stack.peek(), ind);
            res[ind++]=stack.pop();
        }
        for(int i = 0; i < numCourses; i++) {
            for(Integer it : adj.get(i)) {
                if (pos.get(i) > pos.get(it)) return new int[0];
            }
        }
        
        return res;
    }
    void topoSort(int i, List<List<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[i]=true;
        for(Integer it: adj.get(i)){
            if(!vis[it]) topoSort(it, adj, vis, st);
        }
        st.push(i);
    }
    void adjacencyList(int[][] arr, List<List<Integer>> adj){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int node = arr[i][1];
            int vert = arr[i][0];
            adj.get(node).add(vert);
        }
    }
}