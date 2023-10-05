class Solution {
    public int minOperations(List<Integer> nums, int limit) {
        int i = nums.size();
        Set<Integer> set = new HashSet<>();
        for(int k = 1; k <= limit; k++){
            set.add(k);
        }
        while(i-- > 0){
            if(set.contains(nums.get(i))){
                set.remove(nums.get(i));
            }
            if(set.size() == 0){
                return nums.size() - i;
            }   
        }
        return nums.size();
    }
}