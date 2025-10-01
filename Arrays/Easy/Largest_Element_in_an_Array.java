import java.util.Arrays;

public class Largest_Element_in_an_Array {
    public static void main(String[] args) {
        int[] nums = { 3, 7, 2, 9, 5 };
        int result = findLargestUsingLoop(nums);
        System.out.println("Largest number is-> " + result);
    }

    // Approach-1) Using for loop
    // T.C -> O(N), S.C -> O(1)
    // Best practical way in interviews → simple and efficient.
    public static int findLargestUsingLoop(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int largestNo = nums[0];
        for (int i = 1; i < nums.length; i++) {
            largestNo = Math.max(largestNo, nums[i]);
        }
        return largestNo;
    }

    // Approach-2) Using Sorting
    // T.C -> O(NlogN), S.C -> O(1) (ignoring sorting’s internal space)
    // Not optimal when the task is just finding the maximum, but it works
    public static int findLargestUsingSorting(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        return temp[temp.length - 1];
    }

    // Approach-3) Using Recursion
    // T.C-> O(N), S.C-> O(N) (stack space because of recursion calls)
    // Good for demonstrating recursion, though not practical for large arrays
    // Logic: At each recursive call, compare the last element nums[n-1] with the
    // maximum of the remaining array.
    public static int findLargestRecursive(int[] nums, int n) {
        if (n == 1) {
            return nums[0];
        }

        int maxInRest = findLargestRecursive(nums, n - 1);

        if (nums[n - 1] > maxInRest) {
            return nums[n - 1];
        } else {
            return maxInRest;
        }
    }
}