class Solution {
    private char[] root = new char[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        init();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char x = s1.charAt(i);
            char y = s2.charAt(i);
            union(x, y);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append(findRoot(c));
        }
        return sb.toString();
    }

    private void init() {
        for (int i = 0; i < 26; i++) {
            root[i] = (char) ('a' + i);
        }
    }

    private char findRoot(char x) {
        if (x == root[x - 'a'])
            return x;
        return root[x - 'a'] = findRoot(root[x - 'a']);
    }

    public void union(char x, char y) {
        char rootX = findRoot(x);
        char rootY = findRoot(y);
        if (rootX != rootY) {
            if (rootX > rootY) {
                root[rootX - 'a'] = rootY;
            } else {
                root[rootY - 'a'] = rootX;
            }
        }
    }
}