class Solution {
    public int countWays(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }
        Arrays.sort(arr);
        int ans = 0;
        // smaller than group | larger than group
        int numSelected = 0;

        // {}| larger than group
        if (arr[0] > numSelected) {
            ans++;
        }
        for (int i = 0; i < arr.length; i++) {
            // select i-th student;
            // {nums.get(0),..., nums.get(i)} | {nums.get(i+1),...}
            numSelected++;
            if (numSelected > arr[i]
                    && (i == arr.length - 1 || numSelected < arr[i + 1])) {
                ans++;
            }
        }
        return ans;
    }
}