class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans= new ArrayList<>();
        for(int i =0;i<numRows;i++){
            ArrayList<Integer> ds = new ArrayList<>();
            ds.add(1);
            if(i==0){
                ans.add(new ArrayList<>(ds));
                if(numRows==1)
                break;
            }
            else if(i==1){
                ds.add(1);
                ans.add(new ArrayList<>(ds));
                if(numRows==2)
                break;
            }
            
            else{
                 for(int j=0;j<i-1;j++){
                ds.add(ans.get(i-1).get(j)+ans.get(i-1).get(j+1));
            }
            ds.add(1);
            ans.add(new ArrayList<>(ds));
            }
           
        }
        return ans;
    }
}