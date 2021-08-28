class Solution {
    public int findLUSlength(String[] strs) {
        int LUS=-1;
        for (int i=0;i<strs.length;i++){
            int curr=strs[i].length();
            boolean flag=false;
            for(int j=0;j<strs.length;j++){
                if(i!=j && isSubsequence(strs[i], strs[j]))
                {
                    flag=true;
                    break;
                }
            }
            if(!flag){
                LUS=Math.max(LUS, curr);
            }
        }
        return LUS;
    }
    boolean isSubsequence(String a , String b){
        if(a.equals(b))
            return true;
        int i=0; int j=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(j++)){
                i++;
            }
        }
        return i==a.length();
    }
}