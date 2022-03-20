import java.util.*;

class Solution {
    private static final int MAX = (int) 1e6;

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 32; i++) {
            long curr = (long) Math.pow(x, i);
            if (curr > MAX)
                break;
            for (int j = 0; j < 32; j++) {
                long newCurr = curr + (long) Math.pow(y, j);
                if (newCurr > MAX)
                    break;
                else if (newCurr <= bound) {
                    set.add((int) newCurr);
                }
            }
        }
        res.addAll(set);
        return res;
    }
}public class Powerful Integer {
    
}
