class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return false;
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                String og = s.substring(0, i);
                int m = n / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(og);
                }
                if (sb.toString().compareTo(s) == 0)
                    return true;
            }
        }
        return false;
    }
}