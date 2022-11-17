class Solution {
    String ans = "";
    int count = 0;
    private static char[] letters = {'a', 'b', 'c'};
    public String getHappyString(int n, int k) {
        helper("", n, k);
        return ans;
    }
    private void helper(String curr, int n, int k){
        if(ans.length() > 0) return;
        if(curr.length() == n){
            count++;
            if(count == k) ans = curr;
            return;
        }
        StringBuilder sb = new StringBuilder(curr);
        if(curr.length() == 0){
            for(int i = 0; i < 3; i++){
                sb.append(letters[i]);
                helper(sb.toString(), n, k);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        else{
            char prevChar = sb.charAt(sb.length() - 1);
            for(int i = 1; i < 3; i++){
                if(prevChar == 'b'){
                    i = i == 1 ? -1 : 1;
                }
                sb.append(letters[((prevChar - 'a') + i) % 3]);
                helper(sb.toString(), n, k);
                sb.deleteCharAt(sb.length() - 1);
                if(prevChar == 'b'){
                    i = i == -1 ? 1 : 2;
                }
            }
        }
    }
}