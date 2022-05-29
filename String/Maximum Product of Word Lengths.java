class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        
        int max = 0;
        int n = words.length;
        int[] bitValue = new int[n];
        
        for(int i = 0; i < n; i++){
            String word = words[i];
            int len = word.length();
            for(int j = 0; j < len; j++){
                bitValue[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if((bitValue[i] & bitValue[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
}