class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int n = shifts.length-1;
        
        int[] prefix=new int[n+1];
        StringBuilder sb = new StringBuilder();
        prefix[n]=shifts[n];
        
        for( int i=n-1;i>=0;i--){
            prefix[i]=(shifts[i]+prefix[i+1])%26;
        }
        
        for( int i=0; i<prefix.length;i++){
            int x=(s.charAt(i)-'a')+prefix[i];
            int modchar=x>25?(x%26)+'a':x+'a';
            sb.append(Character.toString(modchar));         
    }
      
        return sb.toString();

    }
}