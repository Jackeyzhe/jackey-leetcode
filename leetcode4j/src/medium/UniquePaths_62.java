package medium;

public class UniquePaths_62 {

    public static void main(String[] args) {
        UniquePaths_62 solution = new UniquePaths_62();
        int m = 3;
        int n = 7;
        int result = solution.uniquePaths(m, n);
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
