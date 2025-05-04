package medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ProductOfArrayExceptSelf_238 solution = new ProductOfArrayExceptSelf_238();
        int[] result = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        return ans;
    }
}
