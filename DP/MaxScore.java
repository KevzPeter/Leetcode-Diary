
/*
 * We are given an array arr of positive elements, a positive integer k and a positive integer m. We can collect an element and add it to our score only if the resulting score is not divisible by m. We can skip at most k contiguous positions (we can skip any number of positions in total as long as we are not skipping more than k at a time). What is the maximum score possible? We start before the first element and have to reach the end. Return -1 if it's not possible.

Example 1:

arr : [1, 2, 3, 4, 5]
k: 2
m: 3

ans: 13

We take 1. Score = 1
We can't take 2, because score will become 3.
We take 3. Score = 1+3 = 4 ... and so on.

Example 2:

arr : [5, 4, 3, 2, 1]
k: 2
m: 3

ans: 11

Constraints:
n = len(arr)
0 < n < 10^4 or 10^5 (don't quite remember)
0 < k < 10
0 < m < 20public class Maximum Score by Skipping at most K positions {
    
}

 */
import java.util.*;

public class MaxScore {
    public static void main(String[] args) {
        int[] input = { 3, 2, 2, 4, 5 };
        int m = 3;
        int k = 2;
        System.out.println(maxScoreCalc(input, k, m));
    }

    public static int maxScoreCalc(int[] arr, int k, int m) {
        int n = arr.length;
        int[][] memo = new int[n + 1][k + 1];
        for (int[] a : memo)
            Arrays.fill(a, -1);
        int ans = helper(0, -1, 0, arr, k, m, n, memo);
        return ans <= 0 ? -1 : ans;
    }

    public static int helper(int currIdx, int lastIdx, int currScore, int[] arr, int k, int m, int n, int[][] memo) {
        if (currIdx > lastIdx + k) {
            return -10_000;
        }
        if (currIdx == n) {
            return currScore;
        }
        if (memo[currIdx][currIdx - lastIdx] != -1)
            return memo[currIdx][currIdx - lastIdx];
        int take = 0;
        if ((currScore + arr[currIdx]) % m != 0) {
            take = helper(currIdx + 1, currIdx, currScore + arr[currIdx], arr, k, m, n, memo);
        }
        int notTake = helper(currIdx + 1, lastIdx, currScore, arr, k, m, n, memo);
        return memo[currIdx][currIdx - lastIdx] = Math.max(take, notTake);
    }
}