class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> rows = new HashMap<>();
        HashMap<String, Integer> cols = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int[] col = new int[n];

            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }

            String rowStr = Arrays.toString(grid[i]);
            String colStr = Arrays.toString(col);

            rows.put(rowStr, rows.getOrDefault(rowStr, 0) + 1);
            cols.put(colStr, cols.getOrDefault(colStr, 0) + 1);
        }

        int equalPairs = 0;

        for (Map.Entry<String, Integer> e : rows.entrySet()) {
            String rowStr = e.getKey();
            int freq = e.getValue();
            if (cols.containsKey(rowStr)) {
                equalPairs += freq * cols.get(rowStr);
            }
        }

        return equalPairs;
    }
}