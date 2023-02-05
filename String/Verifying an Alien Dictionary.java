import java.util.*;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (char c : order.toCharArray()) {
            map.put(c, index++);
        }
        String[] copy = words.clone();
        Arrays.sort(copy, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int diff = 0;
                int min = Math.min(a.length(), b.length());
                for (int i = 0; i < min; i++) {
                    diff = map.get(a.charAt(i)) - map.get(b.charAt(i));
                    if (diff != 0)
                        return diff;
                }
                return a.length() - b.length();
            }
        });
        for (int i = 0; i < n; i++) {
            if (!words[i].equals(copy[i]))
                return false;
        }
        return true;
    }
}