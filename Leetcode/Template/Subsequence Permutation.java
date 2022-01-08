import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        int arr[] = new int[] { 5, 3, 8 };
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        boolean vis[] = new boolean[n];
        // printSub(0, arr, list, n); // print subsequences
        // printPermutations(arr, list, vis); //print permutations using
        // extra space
        // permuteSecond(arr, 0, n-1); // print permutations (space optimized)
        // powerSet(arr, n); // print subsequences using power set
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void printPermutations(int[] arr, ArrayList<Integer> ds, boolean[] vis) {
        if (ds.size() == arr.length) {
            System.out.println(ds);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                ds.add(arr[i]);
                printPermutations(arr, ds, vis);
                ds.remove(ds.size() - 1);
                vis[i] = false;
            }
        }
    }

    static void permuteSecond(int[] arr, int low, int high) {
        if (low == high) {
            for (int i : arr)
                System.out.print(i);
            System.out.println();
            return;
        }
        for (int i = low; i <= high; i++) {
            swap(arr, i, low);
            permuteSecond(arr, low + 1, high);
            swap(arr, i, low);
        }
    }

    static void printSub(int i, int[] arr, List<Integer> list, int n) {
        if (i == n) {
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        printSub(i + 1, arr, list, n);
        list.remove(list.size() - 1);
        printSub(i + 1, arr, list, n);
    }

    static void powerSet(int[] arr, int n) {
        int pow = 1 << n; // Math.pow(2, n);
        for (int i = 0; i < pow; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) // check if 'j'th bit in 'i' is set
                    System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}