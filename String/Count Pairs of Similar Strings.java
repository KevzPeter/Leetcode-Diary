class Solution {
    public int similarPairs(String[] words) {
        int n = words.length;
        int res = 0;
        List<boolean[]> exists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            exists.add(helper(words[i]));
        }
        for (int i = 0; i < n; i++) {
            boolean[] existsI = exists.get(i);
            nextWord: for (int j = i + 1; j < n; j++) {
                boolean[] existsJ = exists.get(j);
                for (int k = 0; k < 26; k++) {
                    if (existsI[k] != existsJ[k]) {
                        continue nextWord;
                    }
                }
                res++;
            }
        }
        return res;
    }

    private boolean[] helper(String str) {
        boolean[] exists = new boolean[26];
        for (char c : str.toCharArray())
            exists[c - 'a'] = true;
        return exists;
    }
}