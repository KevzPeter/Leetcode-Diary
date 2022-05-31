public class QuickSort {
    public static void main(String args[]) {
        int[] arr = { 7, 3, 5, 7, 9, 1, 2, 4, 6, 8, 0, 5 };
        QuickSort obj = new QuickSort();
        obj.sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int j = low - 1;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, j, i);
            }

        }
        swap(arr, j + 1, high);
        return j + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
