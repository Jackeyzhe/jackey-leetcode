package hot;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(combinations, combination, candidates, target, 0);
        return combinations;
    }

    private void dfs(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int target, int idx) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (idx == candidates.length) {
            return;
        }
        dfs(combinations, combination, candidates, target, idx + 1);
        if (target >= candidates[idx]) {
            combination.add(candidates[idx]);
            dfs(combinations, combination, candidates, target - candidates[idx], idx);
            combination.remove(combination.size() - 1);
        }
    }
}
