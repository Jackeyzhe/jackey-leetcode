package medium;

public class ContainerWithMostWater_11 {

    public static void main(String[] args) {
        ContainerWithMostWater_11 solution = new ContainerWithMostWater_11();
        int[] height = new int[]{1,2,4,3};
        int result = solution.maxArea(height);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
