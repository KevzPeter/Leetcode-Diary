class Solution {
    public int minOperations(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int operations = 0;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int freq = e.getValue();
            if (freq == 1)
                return -1;
            if (freq % 3 == 0)
                operations += freq / 3;
            else if ((freq - 2) % 3 == 0)
                operations += (((freq - 2) / 3) + 1);
            else if ((freq - 4) % 3 == 0)
                operations += (((freq - 4) / 3) + 2);
            else
                operations += freq / 2;
        }

        return operations;
    }
}