package easy;

import java.util.Arrays;

public class PlusOne_66 {

    public static void main(String[] args) {
        PlusOne_66 solution = new PlusOne_66();
        int[] digits = new int[]{9, 9};
        System.out.println(Arrays.toString(solution.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
