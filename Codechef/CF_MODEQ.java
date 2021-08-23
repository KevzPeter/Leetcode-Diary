/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_MODEQ {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int N, M;
            String arr[] = br.readLine().split(" ");
            N = Integer.parseInt(arr[0]);
            M = Integer.parseInt(arr[1]);
            CF_MODEQ obj = new CF_MODEQ();
            int result = obj.calculate(N, M);
            System.out.println(result);
            T--;
        }
    }

    // modulo exponentiation
    int calculate(int n, int m) {
        int total = 0;
        if (n == 3) {
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (((m % i) % j) == ((m % j) % i)) {
                    total += 1;
                }
            }
        }
        return total;
    }

}
