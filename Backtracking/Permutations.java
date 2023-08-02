class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        helper(nums, res, new boolean[n], new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, boolean[] visited, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                helper(nums, res, visited, curr);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}