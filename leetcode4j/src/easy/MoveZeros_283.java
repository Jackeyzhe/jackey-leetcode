package easy;

import java.util.Arrays;

public class MoveZeros_283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        MoveZeros_283 solution = new MoveZeros_283();
        solution.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public void moveZeroes(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur++;
            }
        }
        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
