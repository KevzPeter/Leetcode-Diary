class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                list.add(i);
            }
        }
        Collections.sort(list);
        int max = 0;
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            int leftBound = list.get(i);
            int rightBound = n - 1 + leftBound;
            while (j < list.size() && list.get(j) <= rightBound)
                j++;
            max = Math.max(max, j - i);
        }
        return n - max;
    }
}