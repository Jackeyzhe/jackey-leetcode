package medium;

public class SearchInRotatedSortedArray_33 {

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 solution = new SearchInRotatedSortedArray_33();
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
               if (nums[mid] < target && target <= nums[n - 1]) {
                   l = mid + 1;
               } else {
                   r = mid - 1;
               }
            }
        }
        return -1;
    }
}
