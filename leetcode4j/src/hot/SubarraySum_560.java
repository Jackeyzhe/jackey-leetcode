package hot;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum_560 {

    public static void main(String[] args) {
        SubarraySum_560 solution = new SubarraySum_560();
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = solution.subarraySum(nums, k);
        System.out.println(result);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
