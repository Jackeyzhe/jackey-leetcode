package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {
        ThreeSum_15 solution = new ThreeSum_15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            twoSum(nums, first, ans);
        }
        return ans;
    }

    private void twoSum(int[] nums, int first, List<List<Integer>> ans) {
        int second = first + 1;
        int third = nums.length - 1;
        while (second < third) {
            if (nums[second] + nums[third] + nums[first] == 0) {
                ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                second++;
                third--;
                while (second < third && nums[second] == nums[second - 1]) {
                    second++;
                }
                while (second < third && nums[third] == nums[third + 1]) {
                    third--;
                }
            } else if (nums[second] + nums[third] + nums[first] > 0) {
                third--;
            } else {
                second++;
            }
        }
    }
}
