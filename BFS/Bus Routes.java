class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                List<Integer> route = adj.getOrDefault(stop, new ArrayList<>());
                route.add(i);
                adj.put(stop, route);
            }
        }
        int minBuses = bfs(source, target, adj, routes);
        return minBuses;
    }

    private int bfs(int source, int target, HashMap<Integer, List<Integer>> adj, int[][] routes) {
        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet<>();
        for (int route : adj.get(source)) {
            q.offer(route);
            visited.add(route);
        }
        int buses = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int currentRoute = q.poll();
                for (int stop : routes[currentRoute]) {
                    if (stop == target)
                        return buses;
                    for (int nextRoute : adj.get(stop)) {
                        if (!visited.contains(nextRoute)) {
                            visited.add(nextRoute);
                            q.add(nextRoute);
                        }
                    }
                }
            }
            ++buses;
        }
        return -1;
    }
}