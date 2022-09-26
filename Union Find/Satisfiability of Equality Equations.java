// daily challenge: 26/9/22
class Solution {
    int[] union = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            union[i] = i;
        }
        for (String eq : equations) {
            int x = eq.charAt(0) - 'a';
            int y = eq.charAt(3) - 'a';
            if (eq.charAt(1) == '=') {
                union[find(x)] = find(y);
            }
        }
        for (String eq : equations) {
            int x = eq.charAt(0) - 'a';
            int y = eq.charAt(3) - 'a';
            if (eq.charAt(1) == '!' && find(x) == find(y)) {
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if (union[x] != x)
            union[x] = find(union[x]);
        return union[x];
    }
}