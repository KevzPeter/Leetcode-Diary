class TrieNode {
    TrieNode[] children;
    int index;

    public TrieNode() {
        children = new TrieNode[27];
    }

    public void insert(String s, int index) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            int n = c - 'a';
            if (cur.children[n] == null) {
                cur.children[n] = new TrieNode();
            }
            cur = cur.children[n];
            cur.index = index;
        }
    }

    public int startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = cur.children[c - 'a'];
            if (next == null) {
                return -1;
            }
            cur = next;
        }
        return cur.index;
    }
}

class WordFilter {

    TrieNode root;

    // apple -> {apple, e{apple, le{apple, ple{apple, pple{apple, apple{apple;
    public WordFilter(String[] words) {
        root = new TrieNode();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String s = words[i];
            for (int j = 0; j <= s.length(); j++) {
                root.insert(s.substring(j, s.length()) + '{' + s, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return root.startsWith(suffix + '{' + prefix);
    }
}
