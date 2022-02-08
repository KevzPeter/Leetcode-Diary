//author : @kevzpeter
//problem : https://leetcode.com/problems/add-digits/
//date : 08-02-2022
/*
****************************Notes*********************************
For base b (decimal case b = 10), the digit root of an integer is:

dr(n) = 0 if n == 0
dr(n) = (b-1) if n != 0 and n % (b-1) == 0
dr(n) = n mod (b-1) if n % (b-1) != 0
*/
class Solution {
    // TC : O(1)
    public int addDigits(int num) {
        if (num == 0)
            return 0;
        int r = num % 9;
        return r == 0 ? 9 : r;
    }
    /*
     * Recursive Solution
     * TC : O(n) --> n = digits in num
     * public int addDigits(int num) {
     * if(num < 10) return num;
     * int sum = 0;
     * while(num>0){
     * sum += num%10;
     * num/=10;
     * }
     * return addDigits(sum);
     * }
     */

}
