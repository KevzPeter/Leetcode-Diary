class Solution {
    public List<Integer> majorityElement(int[] nums) {
    
        int count1=0; int count2=0; int num1=-1; int num2=-1;
        for( int i =0; i <nums.length;i++){
            if(num1==nums[i])
                count1++;
            else if(num2==nums[i])
                count2++;
            else if(count1==0){
                num1=nums[i];
                count1++;
            }
            else if(count2==0){
                num2=nums[i];
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans= new ArrayList<>();
        int c1=0; int c2=0;
        for( int i=0; i<nums.length;i++){
            if(nums[i]==num1)
                c1++;
            else if(nums[i]==num2)
                c2++;
        }
        if(c1>(int)Math.floor(nums.length/3))
            ans.add(num1);
        if(c2>(int)Math.floor(nums.length/3))
            ans.add(num2);
        return ans;
    }
}