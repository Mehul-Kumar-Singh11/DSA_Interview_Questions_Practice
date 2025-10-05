import java.util.Arrays;

public class Left_rotate_an_array_by_one_place {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        // int[] temp = leftRotate(nums);
        int[] temp2 = leftRotateUsingReversalAlgo(nums);
        // System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(temp2));
    }

    // Approach-1) Using for loop
    // T.C -> O(N), S.C-> O(1)
    public static int[] leftRotate(int[] nums) {
        int firstElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = firstElement;
        return nums;
    }

    // Approach-2) Reversal ALgorithm (Expected Approach)
    // T.C -> O(N), S.C-> O(1)
    public static int[] leftRotateUsingReversalAlgo(int[] nums) {
        int d = 1; // in this d will always be 1
        rotate(nums, 0, d - 1);
        rotate(nums, d, nums.length - 1);
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
