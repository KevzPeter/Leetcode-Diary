class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int longestDuration = releaseTimes[0];
        
        for( int i=1; i <releaseTimes.length;i++){
            
            int currTime=releaseTimes[i]-releaseTimes[i-1];
            char currChar=keysPressed.charAt(i);
            
            if(currTime>=longestDuration){
                if(currTime==longestDuration) ans=currChar>ans?currChar:ans;
                else ans=currChar;
                longestDuration=currTime;
            }
        }
        return ans;
    }
}