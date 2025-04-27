package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        SubarraySumEqualsK_560 solution = new SubarraySumEqualsK_560();
        int result = solution.subarraySum(nums, k);
        System.out.println(result);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
