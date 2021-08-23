import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_COCONUT {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            String arr[] = br.readLine().split(" ");
            int xa = Integer.parseInt(arr[0]);
            int xb = Integer.parseInt(arr[1]);
            int XA = Integer.parseInt(arr[2]);
            int XB = Integer.parseInt(arr[3]);
            CF_COCONUT obj = new CF_COCONUT();
            int result = obj.calculate(xa, xb, XA, XB);
            System.out.println(result);
            T--;
        }
    }

    int calculate(int a, int b, int c, int d) {
        return ((c / a) + (d / b));
    }
}