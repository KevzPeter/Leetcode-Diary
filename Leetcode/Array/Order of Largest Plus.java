class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
       
        int grid[][]=new int[n][n];
        Arrays.stream(grid).forEach(a -> Arrays.fill(a, 1));
        for(int i=0;i<mines.length;i++){
            grid[mines[i][0]][mines[i][1]]=0;
        }
        int A[][]=new int [n][n];
        int B[][]=new int [n][n];
        int C[][]=new int [n][n];
        int D[][]=new int [n][n];
        
         for(int i=0;i<n;i++){
            int c=1;
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0)
                A[i][j]=c++;
                else{
                    c=0;
                    A[i][j]=c++;
                }
            }
        }
        for(int i=0;i<n;i++){
            int c=1;
            for(int j=n-1;j>=0;j--){
               if(grid[i][j]!=0)
               B[i][j]=c++;
               else{
                   c=0;
                   B[i][j]=c++;
               }
            }
        }
        for(int j=0;j<n;j++){
            int c=1;
            for(int i=0;i<n;i++){
                if(grid[i][j]!=0)
                C[i][j]=c++;
                else{
                    c=0;
                    C[i][j]=c++;
                }
            }
        }
        for(int j=0;j<n;j++){
            int c=1;
            for(int i=n-1;i>=0;i--){
                if(grid[i][j]!=0)
                D[i][j]=c++;
                else{
                    c=0;
                    D[i][j]=c++;
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                 ArrayList<Integer> ds = new ArrayList<>();
                ds.add(A[i][j]); ds.add(B[i][j]); ds.add(C[i][j]); ds.add(D[i][j]);
                 int min = Collections.min(ds);
            max=min>max?min:max;
            }
        }
        return max;
    }
}