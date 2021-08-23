/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_LKDNGOLF {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        while (T > 0) {
            int N, X, K;
            String arr[] = in.nextLine().split(" ");
            N = Integer.parseInt(arr[0]);
            X = Integer.parseInt(arr[1]);
            K = Integer.parseInt(arr[2]);
            CF_LKDNGOLF obj = new CF_LKDNGOLF();
            String result = obj.calculate(N, X, K);
            System.out.println(result);
            T--;
        }
    }

    String calculate(int n, int x, int k) {
        if (x % k == 0)
            return "YES";
        else if ((n + 1 - x) % k == 0)
            return "YES";
        else
            return "NO";
    }
}
