import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            res.add(i);
            while (res.size() > 1 && gcd(res.get(res.size() - 1), res.get(res.size() - 2)) > 1) {
                long mult = (long) res.get(res.size() - 1) * res.get(res.size() - 2);
                int lcm = (int) (mult / gcd(res.get(res.size() - 1), res.get(res.size() - 2)));
                res.remove(res.size() - 1);
                res.remove(res.size() - 1);
                res.add(lcm);
            }
        }
        return res;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}