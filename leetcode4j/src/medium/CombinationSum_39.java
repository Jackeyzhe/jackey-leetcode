package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public static void main(String[] args) {
        CombinationSum_39 solution = new CombinationSum_39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(candidates, target, ans, combination, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combination, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        if (idx == candidates.length) {
            return;
        }
        dfs(candidates, target, ans, combination, idx + 1);
        if (target - candidates[idx] >= 0) {
            combination.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combination, idx);
            combination.remove(combination.size() - 1);
        }
    }
}
