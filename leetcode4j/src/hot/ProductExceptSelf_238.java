package hot;

import java.util.Arrays;

public class ProductExceptSelf_238 {

    public static void main(String[] args) {
        ProductExceptSelf_238 solution = new ProductExceptSelf_238();
        int[] nums = {1, 2, 3, 4};
        int[] ans = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        l[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        r[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }
}
