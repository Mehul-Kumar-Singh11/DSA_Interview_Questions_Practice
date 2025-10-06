package Tricky;

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 2, 0, 4 };
        int result = solution1UsingForLoops(nums);
        System.out.println("Result-> " + result);
    }

    // Approach-1) Using two for loops
    // T.C-> O(N^2), S.C-> O(1)
    public static int solution1UsingForLoops(int[] height) {
        int n = height.length;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            // Calculate left max
            int leftMax = height[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            // Calculate right max
            int rightMax = height[i];
            for (int k = i + 1; k < n; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    // Approach-2) Using extra space (two arrays)
    // T.C-> O(N), S.C-> O(N)
    public static int solution2UsingTwoArrays(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];

        leftMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int minBtnLeftAndRightMax = Math.min(leftMax[i], rightMax[i]);
            ans += minBtnLeftAndRightMax - nums[i];
        }
        return ans;
    }
}