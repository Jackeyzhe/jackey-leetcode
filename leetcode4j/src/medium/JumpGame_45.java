package medium;

public class JumpGame_45 {

    public static void main(String[] args) {
        JumpGame_45 solution = new JumpGame_45();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int result = solution.jump(nums);
        System.out.println(result);
    }

    public int jump(int[] nums) {
        int maxPosition = 0;
        int end = 0;
        int steps = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
