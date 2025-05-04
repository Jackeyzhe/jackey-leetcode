package medium;

public class MaximumSubarray_53 {

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray_53 solution = new MaximumSubarray_53();
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}
