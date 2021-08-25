class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        for(int i=0;i<Math.pow(2, nums.length);i++){
            List<Integer> ds=new ArrayList<>();
            for (int j=0;j<nums.length;j++){
                if((i & 1<<j)!=0){
                    ds.add(nums[j]);
                }
            }
            ans.add(ds);
        }
        return ans;
    }
}