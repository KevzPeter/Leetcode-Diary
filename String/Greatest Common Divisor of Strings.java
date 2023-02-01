//TC : O(min(n, m) . (m + n))
//SC: O(min(m, n))
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        List<Integer> factors = findFactors(len1, len2);
        String gcd = "";
        outer: for (int factor : factors) {
            String substr = str1.substring(0, factor);
            for (i = 0; i < len1; i += factor) {
                String check = str1.substring(i, i + factor);
                if (!check.equals(substr))
                    continue outer;
            }
            for (i = 0; i < len2; i += factor) {
                String check = str2.substring(i, i + factor);
                if (!check.equals(substr))
                    continue outer;
            }
            return substr;
        }
        return gcd;
    }
    private List<Integer> findFactors(int n1, int n2) {
        int min = Math.min(n1, n2);
        List<Integer> factors = new ArrayList<>();
        for (int i = min; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}
// TC : O(m+n)
// SC : O(m+n)
class Solution_Faster {
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }    
    }
    
    public String gcdOfStrings(String str1, String str2) {
        // Check if they have non-zero GCD string.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // Get the GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }
}