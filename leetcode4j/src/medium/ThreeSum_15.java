package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {
        ThreeSum_15 solution = new ThreeSum_15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            twoSum(nums, first, ans);
        }
        return ans;
    }

    private void twoSum(int[] nums, int first, List<List<Integer>> ans) {
        int target = -nums[first];
        int second = first + 1;
        int third = nums.length - 1;
        while (second < third) {
            int sum = nums[second] + nums[third];
            if (sum == target) {
                ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                second++;
                third--;
                while (second < third && nums[second] == nums[second - 1]) {
                    second++;
                }
                while (second < third && nums[third] == nums[third + 1]) {
                    third--;
                }
            } else if (sum < target) {
                second++;
            } else {
                third--;
            }
        }
    }
}
