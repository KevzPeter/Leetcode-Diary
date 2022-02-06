// day 6
//O(n) SC=TC
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for( int i =0;i<nums.length;i++){
            if(set.contains(nums[i])) ans.add(nums[i]);
            else set.add(nums[i]);
        }
        return ans;
    }
}
//O(n) TC O(1) SC
class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int j = Math.abs(arr[i])-1;
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                ans.add(j+1);
        }
        return ans;
    }
}