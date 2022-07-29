class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0 || pattern == null || pattern.length() == 0) return res;
        
        for(String word : words){
            char[] map = new char[26];
            boolean[] seen = new boolean[26];
            boolean flag = true;
            
            for(int i = 0; i < word.length(); i++){
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                if(map[p - 'a'] == '\u0000' && !seen[w - 'a']){
                        map[p - 'a'] = w;
                        seen[w - 'a'] = true;
                }
                else if((map[p - 'a'] == '\u0000' && seen[w - 'a']) || map[p - 'a'] != w){
                    flag = false;
                    break;
                }
            }
            
            Arrays.fill(map, '\u0000');
            Arrays.fill(seen, false);
            
            if(flag) res.add(word);
        }
        
        return res;
    }
}