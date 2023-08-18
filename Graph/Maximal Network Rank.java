class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads == null || roads.length == 0 || roads[0].length == 0 || n < 2)
            return 0;
        List<Set<Integer>> connectedCities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connectedCities.add(new HashSet<>());
        }
        for (int[] road : roads) {
            int cityA = road[0];
            int cityB = road[1];
            connectedCities.get(cityA).add(cityB);
            connectedCities.get(cityB).add(cityA);
        }
        int maxRank = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = connectedCities.get(i).size() + connectedCities.get(j).size();
                if (connectedCities.get(i).contains(j)) {
                    rank = rank - 1;
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}