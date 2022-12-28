class Solution {
    public int takeCharacters(String s, int k) {

        int N = s.length(), j = 0, ans = N + 1, window = 0;
        Map<Character, Integer> count = new HashMap<Character, Integer>();

        for (int i = 0; i < N; i++)
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);

        if ((count.getOrDefault('a', 0) < k) || (count.getOrDefault('b', 0) < k) || (count.getOrDefault('c', 0) < k))
            return -1;

        for (int i = 0; i < N; i++) {

            char c = s.charAt(i);
            count.put(c, count.get(c) - 1);
            window++;

            while (count.get(c) < k) {
                count.put(s.charAt(j), count.get(s.charAt(j)) + 1);
                window--;
                j++;
            }

            ans = Math.min(ans, N - window);
        }

        return ans;
    }
}