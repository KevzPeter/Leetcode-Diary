public class Remove_Duplicates_In_Sorted_Array_II {
    public static void main(String args[]) {
        int arr[] = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        Solution obj = new Solution();
        System.out.println(obj.removeDuplicates(arr));
    }
}

// TC : O(n)
// SC : O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0], c = 1, j = 0;
        for (int i : nums) {
            if (i == prev && c <= 2) {
                nums[j++] = i;
                c++;
            } else if (i == prev && c > 2)
                continue;
            else if (i != prev) {
                c = 1;
                prev = i;
                nums[j++] = i;
                c++;
            }
        }
        return j;
    }
}