/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_SOLBLTY {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        while (T > 0) {
            int X, A, B;
            String arr[] = in.nextLine().split(" ");
            X = Integer.parseInt(arr[0]);
            A = Integer.parseInt(arr[1]);
            B = Integer.parseInt(arr[2]);
            CF_SOLBLTY obj = new CF_SOLBLTY();
            int result = obj.calculateMass(X, A, B);
            System.out.println(result);
            T--;
        }
    }

    int calculateMass(int x, int a, int b) {
        int ans = 0;
        ans = (a + ((100 - x) * b)) * 10;
        return ans;
    }
}
