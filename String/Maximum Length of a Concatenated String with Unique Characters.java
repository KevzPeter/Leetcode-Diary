class Solution {
    public int maxLength(List<String> arr) {
        return helper(arr, 0, new int[26]);
    }
    private int helper(List<String> arr, int idx, int[] freq){
        if(idx >= arr.size()) return 0;
        int[] freqCopy = freq.clone();
        String curr = arr.get(idx);
        boolean flag = true;
        for(char c : curr.toCharArray()){
            freqCopy[c - 'a']++;
            if(freqCopy[c - 'a'] > 1){
                flag = false;
                break;
            }
        }
        int ans = 0;
        if(flag){
            ans = Math.max(ans, curr.length() + helper(arr, idx+1, freqCopy));
        }
        return ans = Math.max(ans, helper(arr, idx+1, freq));
    }
}