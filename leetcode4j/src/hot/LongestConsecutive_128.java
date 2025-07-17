package hot;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive_128 {

    public static void main(String[] args) {
        LongestConsecutive_128 solution = new LongestConsecutive_128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int curLen = 1;
                while (set.contains(cur + 1)) {
                    cur = cur + 1;
                    curLen = curLen + 1;
                }
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
            }
        }
        return maxLen;
    }
}
