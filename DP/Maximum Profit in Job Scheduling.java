class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][]arr=new int[profit.length][3];
        
        for(int i =0;i<startTime.length;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        return findMaxProfit(arr, arr.length);
    }
    int latestNonConflict(int arr[][], int i) {
        for (int j=i-1; j>=0; j--)
        {
            if (arr[j][1] <= arr[i][0])
                return j;
        }
        return -1;
    }
 
    int findMaxProfit(int arr[][], int n) {
        Arrays.sort(arr, (int[]a,int[]b)->a[1]-b[1]);

        int table[] = new int[n];
        table[0] = arr[0][2];

        for (int i=1; i<n; i++)
        {
            int inclProf = arr[i][2];
            int l = latestNonConflict(arr, i);
            if (l != -1)
                inclProf += table[l];

            table[i] = Math.max(inclProf, table[i-1]);
        }

        return table[n-1];
    }
}