class Solution {
    String ans;
    int count;
    public String getHappyString(int n, int k) {
        if(k > (3 * (1 << (n - 1)))) return "";
        generateHappyStrings(n, ' ', new StringBuilder(), k);
        return ans;
    }
    private void generateHappyStrings(int n, char prev, StringBuilder curr, int k){
        if(n == 0){
            count++;
            if(count == k){
                ans = curr.toString();
            }
            return;
        }
        for(int i = 0; i < 3; i++){
            char currentChar = (char)(i + 'a');
            if(currentChar != prev){
                curr.append(currentChar);
                generateHappyStrings(n - 1, currentChar, curr, k);
                curr.setLength(curr.length() - 1);
            }
        }
    }
}