package hot;

import java.util.ArrayList;
import java.util.List;

public class Permute_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtracing(ans, cur, nums);
        return ans;
    }

    private void backtracing(List<List<Integer>> ans, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
        }
        for (int num : nums) {
            if (!cur.contains(num)) {
                cur.add(num);
                backtracing(ans, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
