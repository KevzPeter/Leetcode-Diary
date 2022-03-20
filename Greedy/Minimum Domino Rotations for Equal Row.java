class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int turnNum = 0;
        for (int num = 1; num <= 6; num++) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (tops[i] != num && bottoms[i] != num) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                turnNum = num;
                break;
            }
        }
        if (turnNum == 0)
            return -1;
        int topCount = 0, bottomCount = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] == turnNum)
                topCount++;
            if (bottoms[i] == turnNum)
                bottomCount++;
        }
        return n - Math.max(topCount, bottomCount);
    }
}