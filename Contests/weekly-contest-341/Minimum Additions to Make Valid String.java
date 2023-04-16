class Solution {
    public int addMinimum(String word) {
        int n = word.length(), i = 0, res = 0;

        while (i < n) {
            int count = 0;

            if (word.charAt(i) == 'a') {
                count++;
                i++;
            }

            if (i < n && word.charAt(i) == 'b') {
                count++;
                i++;
            }

            if (i < n && word.charAt(i) == 'c') {
                count++;
                i++;
            }

            res += 3 - count;
        }

        return res;
    }
}