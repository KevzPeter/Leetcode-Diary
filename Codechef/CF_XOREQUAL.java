/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_XOREQUAL {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int N;
            String arr[] = br.readLine().split(" ");
            N = Integer.parseInt(arr[0]);
            CF_XOREQUAL obj = new CF_XOREQUAL();
            int m = 1000000007;
            long result = obj.calculate(2, (N - 1), m);
            System.out.println(result);
            T--;
        }
    }

    // modulo exponentiation
    long calculate(long x, long y, long p) {
        long res = 1;
        x = x % p;
        if (x == 0)
            return 0;
        while (y > 0) {
            if (y % 2 != 0)
                res = (res * x) % p;
            y = y >> 1;// y=y/2
            x = (x * x) % p;
        }
        return res;
    }

}
