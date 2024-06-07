class Solution {
    private static class TrieNode {
        TrieNode[] children;
        boolean isRoot;

        TrieNode() {
            this.children = new TrieNode[26];
        }

        private void addChild(char c) {
            this.children[c - 'a'] = new TrieNode();
        }

        private boolean hasChild(char c) {
            return this.children[c - 'a'] != null;
        }

        private TrieNode getChild(char c) {
            return this.children[c - 'a'];
        }
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();

        for (String word : dictionary) {
            TrieNode currRoot = root;
            boolean foundRoot = false;
            for (int i = 0; i < word.length() && !foundRoot; i++) {
                char currChar = word.charAt(i);

                if (!currRoot.hasChild(currChar)) {
                    currRoot.addChild(currChar);
                }

                currRoot = currRoot.getChild(currChar);

                if (currRoot.isRoot)
                    foundRoot = true;

                if (i == word.length() - 1) {
                    currRoot.isRoot = true;
                }
            }
        }

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            TrieNode currRoot = root;
            String word = words[i];
            StringBuilder substr = new StringBuilder();
            boolean foundRoot = false;

            for (int j = 0; j < word.length() && !foundRoot; j++) {
                char currChar = word.charAt(j);
                substr.append(currChar);

                if (currRoot.hasChild(currChar)) {
                    currRoot = currRoot.getChild(currChar);
                    if (currRoot.isRoot) {
                        sb.append(substr.toString());
                        if (i < words.length - 1) {
                            sb.append(" ");
                        }
                        foundRoot = true;
                    }
                } else {
                    break;
                }
            }
            if (!foundRoot) {
                sb.append(word);
                if (i < words.length - 1) {
                    sb.append(" ");
                }
            }

        }
        return sb.toString();
    }
}