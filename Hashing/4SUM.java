class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length==0 || nums==null){
            return ans;
        }
        Arrays.sort(nums);
        for( int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                
                int t2=target-(nums[i]+nums[j]);
                int front=j+1;
                int back=nums.length-1;
                
                while(front<back){
                    if(nums[front]+nums[back]==t2){
                        List<Integer> ds = new ArrayList<>();
                        ds.add(nums[i]);
                        ds.add(nums[j]);
                        ds.add(nums[front]);
                        ds.add(nums[back]);
                        ans.add(ds);
                        while(front<back && ds.get(2)==nums[front]) front++;
                        while(front<back && ds.get(3)==nums[back]) back--;
                    }
                    else if(nums[front]+nums[back]>t2) back--;
                    else front++;
                }
                while(j+1<nums.length && nums[j+1]==nums[j])j++;
            }
            while(i+1<nums.length && nums[i+1]==nums[i])i++;
        }
        return ans;
    }
}