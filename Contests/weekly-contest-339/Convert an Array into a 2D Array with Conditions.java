class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = 1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            maxFreq = Math.max(maxFreq, e.getValue());
        }
        for (int i = 0; i < maxFreq; i++) {
            res.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                res.get(i).add(e.getKey());
            }
        }
        return res;
    }
}