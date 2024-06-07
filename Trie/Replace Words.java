class Solution {
    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

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

        outer: for (String word : dictionary) {
            TrieNode currRoot = root;

            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);

                if (!currRoot.hasChild(currChar)) {
                    currRoot.addChild(currChar);
                }

                currRoot = currRoot.getChild(currChar);

                if (currRoot.isWord)
                    continue outer;
                if (i == word.length() - 1) {
                    currRoot.isWord = true;
                }
            }
        }

        String[] words = sentence.split(" ");

        outer: for (int i = 0; i < words.length; i++) {
            TrieNode currRoot = root;
            String word = words[i];
            StringBuilder substr = new StringBuilder();

            for (int j = 0; j < word.length(); j++) {
                char currChar = word.charAt(j);
                substr.append(currChar);

                if (currRoot.hasChild(currChar)) {
                    currRoot = currRoot.getChild(currChar);
                    if (currRoot.isWord) {
                        sb.append(substr.toString());
                        if (i < words.length - 1) {
                            sb.append(" ");
                        }
                        continue outer;
                    }
                } else {
                    break;
                }
            }

            sb.append(word);
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}