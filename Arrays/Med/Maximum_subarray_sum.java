package Med;

public class Maximum_subarray_sum {
    public static void main(String[] args) {
        int[] nums = { -2, -4 };
        int res = maxSubArraySumByAllSubArrays(nums);
        System.out.println("Maximum subarray sum: " + res);
    }

    // Approach-1) By iterating all subarrays
    // T.C-> O(N^2), S.C-> O(1)
    public static int maxSubArraySumByAllSubArrays(int[] nums) {
        int max_sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < nums.length; j++) {
                curr_sum = curr_sum + nums[j];
                max_sum = Math.max(max_sum, curr_sum);
            }
        }
        return max_sum;
    }

    // Approach-2) Kadane's Algorithm (Expected Approach)
    // T.C-> O(N), S.C-> O(1)
    public static int maxSubArraySum(int[] nums) {
        int curr_sum = nums[0];
        int max_sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr_sum = Math.max(nums[i], curr_sum + nums[i]);
            max_sum = Math.max(max_sum, curr_sum);
        }

        return max_sum;
    }

}
