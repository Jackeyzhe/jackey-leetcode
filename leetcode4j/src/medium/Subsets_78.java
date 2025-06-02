package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    public static void main(String[] args) {
        Subsets_78 solution = new Subsets_78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : res) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            res.addAll(newSubsets);
        }
        return res;
    }
}
