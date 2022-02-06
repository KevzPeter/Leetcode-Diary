class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        Set<Integer> set=new HashSet<>();
        for(int i : nums)
            set.add(i);
        int max=0;
        for (int i : nums){
            if(!set.contains(i-1)){
                int currmax=1;
                int curr=i;
                while(set.contains(curr+1)){
                    currmax++;
                    curr++;
                }
                max=Math.max(currmax, max);
            }
        }
        return max;
    }
}