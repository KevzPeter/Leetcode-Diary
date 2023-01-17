class Solution {
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int prevZero = 0, prevOne = 0, currZero = 0, currOne = 0;
        for (int i = n - 1; i >= 0; i--) {
            int dig = s.charAt(i) - '0';
            currZero = dig == 0 ? Math.min(prevZero, prevOne) : Math.min(prevZero, prevOne) + 1;
            currOne = dig == 0 ? prevOne + 1 : prevOne;
            prevZero = currZero;
            prevOne = currOne;
        }
        return Math.min(prevZero, prevOne);
    }
}
