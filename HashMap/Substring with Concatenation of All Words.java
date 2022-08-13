class Solution {
    private HashMap<String, Integer> wordCount;
    private int substringSize, wordLen, k;

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        int n = s.length();
        k = words.length;
        wordLen = words[0].length();
        substringSize = wordLen * k;
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean check(int i, String s) {
        HashMap<String, Integer> remaining = new HashMap<>(wordCount);
        int wordsUsed = 0;
        for (int j = i; j < i + substringSize; j += wordLen) {
            String sub = s.substring(j, j + wordLen);
            if (remaining.getOrDefault(sub, 0) != 0) {
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            } else {
                break;
            }
        }

        return wordsUsed == k;
    }
}