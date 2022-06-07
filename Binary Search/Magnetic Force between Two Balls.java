class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int low = 0, high = position[len - 1] - position[0];
        while(low < high){
            int mid = high - ((high - low) / 2);
            if(count(mid, position) >= m){
                low = mid;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    private int count(int minDist, int[] position){
        int ans = 1, curr = position[0];
        int len = position.length;
        for(int i = 1; i < len; i++){
            if(position[i] - curr >= minDist){
                curr = position[i];
                ans++;
            }
        }
        return ans;
    }
}