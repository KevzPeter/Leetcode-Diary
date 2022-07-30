class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        if (words1.length == 0 || words2.length == 0)
            return res;

        int[] minCharNeeded = new int[26];

        for (String word : words2) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minCharNeeded[i] = Math.max(minCharNeeded[i], freq[i]);
            }
        }

        for (String word : words1) {
            boolean isUniversal = true;
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i] < minCharNeeded[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal)
                res.add(word);
        }

        return res;
    }
}