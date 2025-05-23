package hard;

public class FirstMissingPositive_41 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        FirstMissingPositive_41 solution = new FirstMissingPositive_41();
        int result = solution.firstMissingPositive(nums);
        System.out.println(result);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
