import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CF_CHFHEIST {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            String arr[] = br.readLine().split(" ");
            int D = Integer.parseInt(arr[0]);
            int d = Integer.parseInt(arr[1]);
            int P = Integer.parseInt(arr[2]);
            int Q = Integer.parseInt(arr[3]);
            CF_CHFHEIST obj = new CF_CHFHEIST();
            int result = obj.calculate(D, d, P, Q);
            System.out.println(result);
            T--;
        }
    }

    int calculate(int D, int d, int P, int Q) {
        int sum = 0;
        int mul;
        if (D % d == 0)
            mul = D / d;
        else
            mul = (D / d) + 1;
        for (int i = 0; i < mul; i++) {
            if (i == 0)
                sum = sum + (d * P);
            else if ((i == mul - 1) && (D % d != 0)) {
                sum = sum + ((P + (i * Q)) * (D % d));
            } else {
                sum = sum + ((P + (i * Q)) * d);
            }

        }
        return sum;
    }
}