class TrieNode{
    TrieNode[] children;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class Solution {
    TrieNode root = new TrieNode();
    
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        int minLength = 0;
        
        HashSet<String> set = new HashSet<>();
        
        for(String word : words){
            if(!set.contains(word)){
                set.add(word);
                insertToTrie(word);
            }
        }
        
        for(String word : set){
            if(!superStringExists(word)){
                minLength += 1 + word.length();
            }
        }
        
        return minLength;
    }
    
    private void insertToTrie(String word){
        int len = word.length();
        TrieNode trie = root;
        
        for(int i = len - 1; i >= 0; i--){
            char c = word.charAt(i);
            if(trie.children[c - 'a'] == null){
                trie.children[c - 'a'] = new TrieNode();
            }
            trie = trie.children[c - 'a'];
        }
    }
    
    private boolean superStringExists(String word){
        int len = word.length();
        TrieNode trie = root;
        
        for(int i = len - 1; i >= 0; i--){
            char c = word.charAt(i);
            trie = trie.children[c - 'a'];
        }
        
        for(int i = 0; i < 26; i++){
            if(trie.children[i] != null) return true;
        }
        
        return false;
    }
}