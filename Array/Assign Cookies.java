class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int happyKids = 0;
        int i = 0, j = 0;
        int m = g.length, n = s.length;
        while (i < m && j < n) {
            while (j < n && s[j] < g[i])
                j++;
            if (j < n)
                happyKids++;
            else
                break;
            j++;
            i++;
        }
        return happyKids;
    }
}