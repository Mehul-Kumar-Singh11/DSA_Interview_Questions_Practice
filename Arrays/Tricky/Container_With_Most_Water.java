package Tricky;

public class Container_With_Most_Water {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 8, 6, 4, 6, 5, 5 };
        int ans = solution1UsingForLoops(heights);
        System.out.println("Maximum water that can be stored btn two lines is: " + ans);
    }

    // Approach-1) Using for loops
    // T.C-> O(N^2), S.C-> O(1)
    public static int solution1UsingForLoops(int[] heights) {
        int maxWaterContained = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                maxWaterContained = Math.max(maxWaterContained, area);
            }
        }
        return maxWaterContained;
    }

    // Approach-2) Using Two pointers (EXPECTED APPROACH)
    // T.C-> O(N), S.C-> O(1)
    public static int solution2UsingTwoPointers(int[] heights) {
        int maxWaterStored = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int minHeight = Math.min(heights[i], heights[j]);
            int width = j - i;
            int area = minHeight * width;
            System.out.println("Area-> " + area);
            maxWaterStored = Math.max(maxWaterStored, area);
            // Move index which has lesser value, in hope of getting bigger value next time
            // as greater the height more water can be contained
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWaterStored;
    }
}
