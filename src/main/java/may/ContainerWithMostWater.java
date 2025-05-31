package may;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int currentMaxArea = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (leftPointer < rightPointer) {
            int area = Math.min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer);
            if (area > currentMaxArea) {
                currentMaxArea = area;
            }

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return currentMaxArea;
    }

    public static void main(String[] args) {
        // Initializing a 2D array that represents an apartment building
        String s1 = "abc";
        String s2 = "ahbgdc";
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(heights);
        System.out.println("The max area is: " + area);
    }
}