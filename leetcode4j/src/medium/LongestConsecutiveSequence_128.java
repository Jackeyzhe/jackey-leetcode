package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        LongestConsecutiveSequence_128 solution = new LongestConsecutiveSequence_128();
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int currentNum = num;
            int currentStreak = 1;
            while (numSet.contains(currentNum + 1)) {
                currentStreak++;
                currentNum++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }
}
