class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Set<String> dup = new HashSet<>();

        int palindromeLength = 0;
        boolean oddCount = false;

        for (String word : words) {
            set.add(word);
            dup.add(word);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            String curr = it.next();
            if (dup.contains(curr)) {
                StringBuilder sb = new StringBuilder(curr);
                String reverse = sb.reverse().toString();
                if (curr.equals(reverse)) {
                    int count = map.get(curr);
                    if (count % 2 != 0) {
                        oddCount = true;
                        palindromeLength += (--count * 2);
                    } else
                        palindromeLength += (count * 2);
                } else if (map.containsKey(reverse)) {
                    int count = Math.min(map.get(curr), map.get(reverse));
                    palindromeLength += 4 * count;
                    dup.remove(curr);
                    dup.remove(reverse);
                }
            }
        }
        palindromeLength += (oddCount ? 2 : 0);
        return palindromeLength;
    }
}
