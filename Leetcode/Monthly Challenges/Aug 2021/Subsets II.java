class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0;i<Math.pow(2,nums.length);i++){
             ArrayList<Integer> curr=new ArrayList<>();
            for( int j=0;j<nums.length;j++){
                if((i & (1 << j)) != 0){
                curr.add(nums[j]);
                }
            }
            
                ans.add(curr);
        }
        List<List<Integer>> finalans=new ArrayList<List<Integer>>();
        for(List i : ans)
            finalans.add(i);
        return finalans;
    }
}