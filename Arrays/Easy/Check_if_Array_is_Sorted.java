public class Check_if_Array_is_Sorted {
    public static void main(String[] args) {
        int[] nums = { 90, 80, 90 };
        boolean result = isSortedRecursive(nums, nums.length);
        System.out.println("Is array sorted-> " + result);
    }

    // Approach-1) Using Recursion
    // T.C-> O(N), S.C-> O(N)
    public static boolean isSortedRecursive(int[] nums, int n) {
        // Base case
        if (n == 0 || n == 1) {
            return true;
        }

        boolean isRemArrSorted = isSortedRecursive(nums, n - 1);
        return (nums[n - 1] >= nums[n - 2] && isRemArrSorted);
    }

    // Approach-2) Using for loop
    // T.C-> O(N), S.C-> O(1)
    public static boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
