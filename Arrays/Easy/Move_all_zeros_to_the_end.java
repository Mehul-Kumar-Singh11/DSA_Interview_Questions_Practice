import java.util.Arrays;

public class Move_all_zeros_to_the_end {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 0, 4, 3, 0, 5, 0 };
        int[] temp = moveZerosToEndOptimized(nums);
        System.out.println(Arrays.toString(temp));
    }

    // Approach-1) Two traversals
    // T.C-> O(N), S.C-> O(1)
    public static int[] moveZerosToEnd(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
        return nums;
    }

    // Approach-2) One Traversal (Expected Approach)
    // T.C-> O(N), S.C -> O(1)
    public static int[] moveZerosToEndOptimized(int[] nums) {
        int j = 0; // to track the position for next non-zero position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }
}
