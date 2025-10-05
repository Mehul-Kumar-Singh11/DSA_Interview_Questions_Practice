import java.util.Arrays;
import java.util.HashSet;

public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
        int k = removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));
    }

    // Approach-1. Using for loop, since array is sorted (Expected Approach)
    // T.C-> O(N), S.C-> O(1)
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j++] = nums[nums.length - 1];
        return j; // return number Of Unique Elements
    }

    // Approach-2) Using HashSets (Works for unsorted array also)
    // T.C-> O(N), S.C-> O(N)
    public static int removeDuplicatesUsingHashSet(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hset.contains(nums[i])) {
                hset.add(nums[i]);
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }
}
