class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for( char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        List<Map.Entry<Character, Integer> > list 
            = new ArrayList<Map.Entry<Character, Integer> >(
                map.entrySet());
 
        // Sort the list using lambda expression
        Collections.sort(
            list,
            (i1,
             i2) -> i2.getValue()-i1.getValue());
        
        char ans[]=new char[s.length()];
        int c=0;
        for(Map.Entry<Character, Integer> e:list){
            for( int i=0;i<e.getValue();i++)
                ans[c++]=e.getKey();
        }
        return new String(ans);
    }
}