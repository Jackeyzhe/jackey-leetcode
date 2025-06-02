package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

    public static void main(String[] args) {
        Permutations_46 solution = new Permutations_46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> cur = new ArrayList<>();
        backtracking(res, cur, nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        }

        for (int num : nums) {
            if (!cur.contains(num)) {
                cur.add(num);
                backtracking(res, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
