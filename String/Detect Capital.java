class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        boolean allSmall = true, allCapital = true, firstCapital = true, restSmall = true;
        for(int i = 0; i < len; i++){
            char c = word.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                allSmall = false;
                if(i > 0) restSmall = false;
            }
            else{
                allCapital = false;
                if(i == 0) firstCapital = false;
            }
        }
        return (allSmall || allCapital || (firstCapital && restSmall));
    }
}