/*
author : @kevzpeter
problem : https://leetcode.com/problems/k-diff-pairs-in-an-array/
date : 09-02-2022
*/
class Solution {
    // TC : O(n)
    // SC : O(n)
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(k==0){
                if(e.getValue() >= 2) count++;
            }
            else{
                if(map.containsKey(e.getKey() + k)) count++;
            }
        }
        return count;
    }
}