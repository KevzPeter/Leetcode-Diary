class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        if(s == null || s.length() == 0) return "";
        int[] letterFreq = new int[26];
        
        for(char c : s.toCharArray()){
            letterFreq[c - 'a']++;
        }
        
        StringBuilder res = new StringBuilder();
        while(true){
            int maxAlpha = -1;
            for(int i=25; i>=0; i--){
                if(letterFreq[i] > 0){
                    maxAlpha = i;
                    break;
                }
            }
            if(maxAlpha == -1) break;
            
            for(int i=0; i < repeatLimit; i++){
                //System.out.println((char)(maxAlpha + 'a')+" "+"repeatLimit: "+(i+1));
                res.append((char)(maxAlpha + 'a'));
                letterFreq[maxAlpha]--;
                if(letterFreq[maxAlpha] == 0) break;
            }
            if(letterFreq[maxAlpha] > 0){
                int secondMaxAlpha = -1;
                for(int i=maxAlpha - 1; i>=0; i--){
                    if(letterFreq[i] > 0){
                        //System.out.println((char)(i + 'a'));
                        secondMaxAlpha = i;
                        res.append((char)(i + 'a'));
                        letterFreq[i]--;
                        break;
                    }
                }
                if(secondMaxAlpha == -1) break;
            }
        }
        return res.toString();
    }
}