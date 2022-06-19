class Solution {
    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || products.length == 0
                || searchWord == null || searchWord.length() == 0)
            return List.of();

        List<List<String>> res = new ArrayList<>();

        Arrays.sort(products);

        for (int i = 0; i < products.length; i++) {
            insert(products[i]);
        }

        TrieNode trie = root;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            trie = trie.children[c - 'a'];
            if (trie == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    res.add(List.of());
                }
                break;
            }
            res.add(trie.products);
        }

        return res;
    }

    public void insert(String word) {
        TrieNode trie = root;
        for (char c : word.toCharArray()) {
            if (trie.children[c - 'a'] == null) {
                trie.children[c - 'a'] = new TrieNode();
            }
            trie = trie.children[c - 'a'];
            if (trie.products.size() < 3) {
                trie.products.add(word);
            }
        }
    }
}

class TrieNode {
    TrieNode[] children;
    List<String> products;

    public TrieNode() {
        children = new TrieNode[26];
        products = new ArrayList<>();
    }
}