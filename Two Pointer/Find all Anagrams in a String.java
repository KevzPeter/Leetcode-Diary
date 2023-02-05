import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] freq = new int[26];
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }
        int end = 0, n = p.length();
        while (end < s.length()) {
            freq[s.charAt(end) - 'a']--;
            if (end >= n) {
                freq[s.charAt(end - n) - 'a']++;
            }
            if (end >= n - 1 && allZero(freq)) {
                list.add(end - n + 1);
            }
            end++;
        }
        return list;
    }

    private boolean allZero(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
}