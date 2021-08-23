/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_ISS {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int N;
            String arr[] = br.readLine().split(" ");
            N = Integer.parseInt(arr[0]);
            CF_ISS obj = new CF_ISS();
            int result = obj.calculate(N);
            System.out.println(result);
            T--;
        }
    }

    int calculate(int k) {
        CF_ISS obj = new CF_ISS();
        int m = 1000000007;
        int total = 0;
        for (int i = 1; i <= (2 * k); i++) {
            total += obj.gcd(k + ((i * i) % m), k + (((i + 1) * (i + 1)) % m));
        }
        return total % m;
    }

    // euclidean GCD
    int gcd(int n1, int n2) {
        return (n2 == 0) ? n1 : gcd(n2, n1 % n2);
    }

    // binary GCD
    // int gcd(int n1, int n2) {
    // if (n1 == 0) {
    // return n2;
    // }

    // if (n2 == 0) {
    // return n1;
    // }

    // int n;
    // for (n = 0; ((n1 | n2) & 1) == 0; n++) {
    // n1 >>= 1;
    // n2 >>= 1;
    // }

    // while ((n1 & 1) == 0) {
    // n1 >>= 1;
    // }

    // do {
    // while ((n2 & 1) == 0) {
    // n2 >>= 1;
    // }

    // if (n1 > n2) {
    // int temp = n1;
    // n1 = n2;
    // n2 = temp;
    // }
    // n2 = (n2 - n1);
    // } while (n2 != 0);
    // return n1 << n;
    // }

}
