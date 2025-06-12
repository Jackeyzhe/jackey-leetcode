package medium;

public class FindMinimumInRotatedSortedArray_153 {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray_153 solution = new FindMinimumInRotatedSortedArray_153();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int result = solution.findMin(nums);
        System.out.println(result);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
