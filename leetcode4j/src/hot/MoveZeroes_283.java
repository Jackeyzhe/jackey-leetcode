package hot;

import java.util.Arrays;

public class MoveZeroes_283 {

    public static void main(String[] args) {
        MoveZeroes_283 solution = new MoveZeroes_283();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
