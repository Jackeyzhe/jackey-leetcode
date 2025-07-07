package medium;

public class MaximumProductSubarray_152 {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        MaximumProductSubarray_152 solution = new MaximumProductSubarray_152();
        int result = solution.maxProduct(nums);
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        long[] maxF = new long[length];
        long[] minF = new long[length];
        for (int i = 0; i < length; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }

        for (int i = 1; i < length; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(maxF[i - 1] * nums[i], nums[i]));
            if (minF[i] < (-1 << 31)) {
                minF[i] = nums[i];
            }
        }
        int ans = (int) maxF[0];
        for (int i = 1; i < length; i++) {
            ans = Math.max(ans, (int) maxF[i]);
        }
        return ans;
    }
}
