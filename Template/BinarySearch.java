import java.util.*;

public class BinarySearch {
    public static void main(String args[]) {
        int[] arr = { 2, 3, 4, 10, 40 };
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to be searched: ");
        int n = in.nextInt();
        System.out.println("Enter 1 for Iterative or 2 for Recursive: ");
        int choice = in.nextInt();
        BinarySearch obj = new BinarySearch();
        switch (choice) {
            case 1:
                System.out.println(obj.binSearchIter(arr, 0, arr.length - 1, n));
                break;
            case 2:
                System.out.println(obj.binSearchRecur(arr, 0, arr.length - 1, n));
                break;
            default:
                System.out.println("Wrong Choice Entered! \n");
        }
        in.close();
    }

    public int binSearchIter(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int binSearchRecur(int[] arr, int low, int high, int target) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                return binSearchRecur(arr, low, mid - 1, target);
            else
                return binSearchRecur(arr, mid + 1, high, target);
        }
        return -1;
    }

    /**
     * The lower bound of a target value in a sorted array is the index of the first
     * element that is greater than or equal to the target. In other words, it is
     * the leftmost position where the target could be inserted without disrupting
     * the order of the array.
     */
    public int lowerBoundBinSearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }

    /**
     * The upper bound of a target value is the index of the first element that is
     * strictly greater than the target. This is useful for finding the end of a
     * range of duplicate elements, or the position where a target would go if it
     * were added to the array.
     */
    public int upperBoundBinSearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }
}
// reference for implementing Upper Bound & Lower bound
// https://medium.com/swlh/binary-search-find-upper-and-lower-bound-3f07867d81fb