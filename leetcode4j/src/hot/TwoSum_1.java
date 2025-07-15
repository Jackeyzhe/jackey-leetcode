package hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        int target = 6;
        TwoSum_1 solution = new TwoSum_1();
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
