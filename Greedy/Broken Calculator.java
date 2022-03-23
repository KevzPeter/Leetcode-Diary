class Solution {
    public int brokenCalc(int start, int target) {
        int count = 0;
        if(start == target) return 0;
        else if(start > target) return start - target;
        while (target > start) {
            count++;
            if (target % 2 == 1)
                target++;
            else
                target /= 2;
        }
        return count + start - target;
    }
}