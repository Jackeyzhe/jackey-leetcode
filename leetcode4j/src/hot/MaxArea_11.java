package hot;

public class MaxArea_11 {

    public static void main(String[] args) {
        MaxArea_11 solution = new MaxArea_11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(height);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int length = right - left;
            int area = length * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
