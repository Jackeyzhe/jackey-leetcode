package medium;

public class JumpGame_55 {

    public static void main(String[] args) {
        JumpGame_55 solution = new JumpGame_55();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean result = solution.canJump(nums);
        System.out.println(result);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(i + nums[i], rightMost);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
