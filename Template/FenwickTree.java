import java.util.*;

public class FenwickTree {
    int[] fenwick;
    int N;

    FenwickTree(int n) {
        fenwick = new int[n + 1];
        N = n;
    }

    public static void main(String[] args) {
        int n = 10;
        FenwickTree tree = new FenwickTree(n);
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(20);
        }
        tree.printArray(arr);
    }

    void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    int sumRange(int l, int r) {
        return sum(r) - sum(l - 1);
    }

    void update(int i, int val) {
        i++;
        while (i <= N) {
            fenwick[i] += val;
            i += (i & (-i));
        }
    }

    int sum(int i) {
        int s = 0;
        i++;
        while (i > 0) {
            s += fenwick[i];
            i -= (i & (-i));
        }
        return s;
    }
}
