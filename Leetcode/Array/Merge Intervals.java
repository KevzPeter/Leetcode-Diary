class Solution {
    public int[][] merge(int[][] intervals) {
        
        ArrayList<List<Integer>> finalans=new ArrayList<>();
        List<int[]>res=new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(intervals.length==0 || intervals==null){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        ans.add(intervals[0][0]);
        ans.add(intervals[0][1]);
        
        for (int i=0; i<intervals.length;i++){
            if(ans.get(1)>=intervals[i][0]){
                ans.set(1, Math.max(ans.get(1), intervals[i][1]));
            }
            else{
                finalans.add(new ArrayList<Integer>(ans));
                ans.set(0, intervals[i][0]);
                ans.set(1, intervals[i][1]);
            }
        }
        finalans.add(new ArrayList<Integer>(ans));
        int[][] array = new int[finalans.size()][2];  
		for(int i=0; i<finalans.size(); i++){ 
			for (int j = 0; j < 2; j++) { 
				array[i][j] = finalans.get(i).get(j); 
			} 
		}
        return array;
    }
}