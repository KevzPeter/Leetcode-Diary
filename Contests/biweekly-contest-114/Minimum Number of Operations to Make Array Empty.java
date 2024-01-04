class Solution {
    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int operations = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int freq = e.getValue();
            if (freq <= 1)
                return -1;
            operations += (freq % 3 == 0) ? freq / 3 : freq / 3 + 1;
        }
        return operations;
    }
}