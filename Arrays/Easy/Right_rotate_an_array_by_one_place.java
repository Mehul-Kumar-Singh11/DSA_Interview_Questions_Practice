import java.util.Arrays;

public class Right_rotate_an_array_by_one_place {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        // int[] temp = rightRotate(nums);
        int[] temp2 = rightRotateUsingReversalAlgo(nums);
        // System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(temp2));
    }

    // Approach-1) Using for loop
    // T.C -> O(N), S.C-> O(1)
    public static int[] rightRotate(int[] nums) {
        int lastElement = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        nums[0] = lastElement;
        return nums;
    }

    // Approach-2) Reversal ALgorithm (Expected Approach)
    // T.C -> O(N), S.C-> O(1)
    public static int[] rightRotateUsingReversalAlgo(int[] nums) {
        int n = nums.length;
        int d = 1; // in this d will always be 1
        rotate(nums, 0, n - d - 1);
        rotate(nums, n - d, n - 1);
        rotate(nums, 0, nums.length - 1);
        return nums;
    }

    public static void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
