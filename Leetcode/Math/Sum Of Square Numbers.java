class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==0)
            return true;
        boolean ans=false;
        for( int i =0;i<=((int)Math.sqrt(c));i++){
          if(Math.sqrt(c-(i*i))-Math.floor(Math.sqrt(c-(i*i)))==0)
               ans=true;
        }
        return ans;
    }
}