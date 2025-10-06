package Tricky;

public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] nums = { -1, -3, -10, 10, 0, 6 };
        int res = solution1(nums);
        System.out.println("Maximum Product subarray value -> " + res);
    }

    // Approach-1) By using two nested loops
    // T.C-> O(N^2), S.C-> O(1)
    public static int solution1(int[] nums) {
        int maxProductValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentProductValue = 1;
            for (int j = i; j < nums.length; j++) {
                currentProductValue = currentProductValue * nums[j];
                maxProductValue = Math.max(maxProductValue, currentProductValue);
            }
        }
        return maxProductValue;
    }

    // Approach-2) By Transversing both directions
    // T.C-> O(N) S.C-> O(1)
    public static int solution2(int[] nums) {
        int n = nums.length;
        int leftProd = 1;
        int rightProd = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {
            leftProd = (leftProd == 0) ? 1 : leftProd;
            rightProd = (rightProd == 0) ? 1 : rightProd;

            leftProd = leftProd * nums[i];
            rightProd = rightProd * nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftProd, rightProd));
        }
        return ans;
    }
}
