package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    public static void main(String[] args) {
        GenerateParentheses_22 solution = new GenerateParentheses_22();
        List<String> result = solution.generateParenthesis(3);
        result.forEach(System.out::println);
    }

    private int n;
    private List<String> ans = new ArrayList<>();
    private char[] path;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2];
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int open) {
        if (i == n * 2) {
            ans.add(new String(path));
            return;
        }
        if (open < n) {
            path[i] = '(';
            dfs(i + 1, open + 1);
        }
        if (i - open < open) {
            path[i] = ')';
            dfs(i + 1, open);
        }
    }
}
