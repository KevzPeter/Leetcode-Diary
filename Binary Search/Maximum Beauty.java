class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = binSearch(queries[i], items);
            if (idx == -1)
                res[i] = 0;
            else
                res[i] = items[idx][1];
        }
        return res;
    }

    private int binSearch(int target, int[][] arr) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid][0] <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}