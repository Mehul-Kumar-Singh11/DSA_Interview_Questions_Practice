import java.util.Arrays;

public class Second_Largest_Element {
    public static void main(String[] args) {
        int[] nums = { 23, 5, 90, 55, 90, 7 };
        int result = secondLargestUsingForLoop(nums);
        System.out.println("Second Largest Element is-> " + result);
    }

    // Approach-1) Using Sorting
    // T.C-> O(NlogN), S.C-> O(1)
    public static int secondLargestUsingSorting(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);

        for (int i = n - 2; i >= 0; i--) {
            if (temp[i] != temp[n - 1]) {
                return temp[i];
            }
        }
        return -1;
    }

    // Approach-2) Using two pass search
    // T.C-> O(2N) = O(N), S.C-> O(1)
    public static int secondLargestUsingTwoPassSearch(int[] nums) {
        int n = nums.length;

        int largest = -1, secondLargest = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }

    // Approach-3) Using one pass search (Expected Approach)
    // T.C-> O(N), S.C-> O(1)
    public static int secondLargestUsingForLoop(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }

        int fmax = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (fmax < nums[i]) {
                smax = fmax;
                fmax = nums[i];
            } else if (smax < nums[i] && fmax != nums[i]) {
                smax = nums[i];
            }
        }
        return (smax == Integer.MIN_VALUE) ? -1 : smax;
    }

}
