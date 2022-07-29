class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, i);
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        while(start < n){
            end = map.get(s.charAt(start));
            int j = start;
            while(j <= end){
                if(map.get(s.charAt(j)) > end){
                    end = map.get(s.charAt(j));
                }
                j++;
            }
            ans.add(end - start + 1);
            start = end + 1;
        }
        return ans;
    }
}