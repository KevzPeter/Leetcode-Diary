class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
               
        int curr_wt=0;
        int max=0;
        
        Arrays.sort(boxTypes, (a, b)->b[1]-a[1]);
        for(int i=0;i<boxTypes.length;i++){
            if(curr_wt+boxTypes[i][0]<=truckSize){
                curr_wt+=boxTypes[i][0];
                max+=boxTypes[i][0]*boxTypes[i][1];
            }
            else{
                max+=boxTypes[i][1]*(truckSize-curr_wt);
                break;
            }
        }
        return max;
    }
}