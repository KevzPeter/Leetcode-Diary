class Solution {
    public void sortColors(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==2)
                list.add(nums[i]);
            if(nums[i]==1)
                list.add(list.lastIndexOf(0)+1,nums[i]);
            if(nums[i]==0)
                list.add(0,nums[i]);
            }
        for(int i=0;i<nums.length;i++){
            nums[i]=list.get(i);
        }
            
        }
    }