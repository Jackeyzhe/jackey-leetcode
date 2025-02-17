package medium;

public class FactorialTrailingZeros_172 {

    public static void main(String[] args) {
        FactorialTrailingZeros_172 solution = new FactorialTrailingZeros_172();
        int n = 5;
        System.out.println(solution.trailingZeroes(n));
    }

    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ans++;
            }
        }
        return ans;
    }
}
