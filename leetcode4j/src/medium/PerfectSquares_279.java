package medium;

public class PerfectSquares_279 {

    public static void main(String[] args) {
        PerfectSquares_279 solution = new PerfectSquares_279();
        int n = 12;
        int result = solution.numSquares(n);
        System.out.println(result);
    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
