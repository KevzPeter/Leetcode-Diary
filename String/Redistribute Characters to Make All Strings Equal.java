class Solution {
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                freq[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] % len != 0)
                return false;
        }
        return true;
    }
}