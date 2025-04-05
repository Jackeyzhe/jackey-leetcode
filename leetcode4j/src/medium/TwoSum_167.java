package medium;

import java.util.Arrays;

public class TwoSum_167 {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSum_167 solution = new TwoSum_167();
        int[] res = solution.twoSum(numbers, target);
        Arrays.stream(res).forEach(System.out::println);
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
