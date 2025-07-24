package hot;

public class MaxSubArray_53 {

    public static void main(String[] args) {
        MaxSubArray_53 solution = new MaxSubArray_53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            max = Math.max(max, pre);
        }
        return max;
    }
}
