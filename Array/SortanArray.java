public class SortanArray {
    public static void main(String args[]) {
        int arr[] = new int[] { 6, 4, 8, 9, 1, 5, 2, 10, 54, 2, 43, 65, 2, 1, 8, 7 };
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        printArray(arr);
    }

    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    static void merge(int arr[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int i, j, k;
        int L[] = new int[n1];
        int M[] = new int[n2];
        for (i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (i = 0; i < n2; i++) {
            M[i] = arr[q + i + 1];
        }
        i = 0;
        j = 0;
        k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= M[j])
                arr[k++] = L[i++];
            else
                arr[k++] = M[j++];
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = M[j++];
    }
}