import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class CF_GRIDSQRS {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int N;
            String arr[] = br.readLine().split(" ");
            N = Integer.parseInt(arr[0]);
            char matrix[][] = new char[N][N];
            int i = 0, j = 0;
            while (N > 0) {
                String line = br.readLine();
                for (char c : line.toCharArray()) {
                    matrix[i][j++] = c;
                }
                i++;
                j = 0;
                N--;
            }
            // print(matrix);
            int result = calculate(matrix);
            System.out.println(result);
            T--;
        }
    }

    static void print(char[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static int calculate(char[][] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxk = Math.min(n - i, n - j);
                if (arr[i][j] == '1') {
                    for (int k = 0; k < maxk; k++) {
                        if (arr[i + k][j] == '1' && arr[i][j + k] == '1' && arr[i + k][j + k] == '1')
                            count++;
                    }
                }
            }
        }
        return count;
    }

    static boolean isValid(int i, int j, int n) {
        return ((i >= 0 && j >= 0) && (i < n && j < n));
    }
}