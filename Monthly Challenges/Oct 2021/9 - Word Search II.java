//using DFS
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        if (words.length == 0 || words == null || board == null || board.length == 0)
            return ans;
        outer: for (String str : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int[][] vis = new int[board.length][board[0].length];
                    if (board[i][j] == str.charAt(0) && check(i, j, str, 0, board, vis)) {
                        ans.add(str);
                        continue outer;
                    }
                }
            }
        }

        return ans;
    }

    boolean check(int i, int j, String word, int idx, char[][] board, int[][] vis) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || idx >= word.length()
                || word.charAt(idx) != board[i][j] || vis[i][j] == 1)
            return false;

        vis[i][j] = 1;

        if (idx == word.length() - 1)
            return true;

        if (check(i + 1, j, word, idx + 1, board, vis)
                || check(i, j + 1, word, idx + 1, board, vis)
                || check(i - 1, j, word, idx + 1, board, vis)
                || check(i, j - 1, word, idx + 1, board, vis))
            return true;
        vis[i][j] = 0;
        return false;
    }
}

// using Trie and DFS
class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null)
            return;
        p = p.next[c - 'a'];
        if (p.word != null) { // found one
            res.add(p.word);
            p.word = null; // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0)
            dfs(board, i - 1, j, p, res);
        if (j > 0)
            dfs(board, i, j - 1, p, res);
        if (i < board.length - 1)
            dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}