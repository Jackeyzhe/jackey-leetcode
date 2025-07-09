package medium;

public class FindTheDuplicateNumber_287 {

    public static void main(String[] args) {
        FindTheDuplicateNumber_287 solution = new FindTheDuplicateNumber_287();
        int[] nums = {1, 3, 4, 2, 2};
        int result = solution.findDuplicate(nums);
        System.out.println(result);
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num] < 0) {
                return num;
            }
            nums[num] = -nums[num];
        }
        return -1;
    }
}
