package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {

    public static void main(String[] args) {
        PascalTriangle_118 solution = new PascalTriangle_118();
        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);
        System.out.println(result);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == i || j == 0) {
                    row.add(1);
                } else {
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
