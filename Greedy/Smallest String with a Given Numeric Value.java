class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(k >= 26 + n - 1 && n > 0){
            sb.append('z');
            k -= 26;
            n--;
        }
        if(k > 0 && n > 0){
            sb.append((char)(k - n + 'a'));
            n--;
            k = n;
        }
        while(k > 0){
            sb.append('a');
            k--;
        }
        return sb.reverse().toString();
    }
}