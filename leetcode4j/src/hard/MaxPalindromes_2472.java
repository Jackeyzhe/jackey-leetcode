package hard;

public class MaxPalindromes_2472 {

    public static void main(String[] args) {
        String s = "abaccdbbd";
        int k = 3;
        MaxPalindromes_2472 solution = new MaxPalindromes_2472();
        int result = solution.maxPalindromes(s, k);
        System.out.println(result);
    }

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int left = 0; len + left <= n; left++) {
                int right = left + len - 1;
                isPalindrome[left][right] = s.charAt(left) == s.charAt(right) && (len <= 2 || isPalindrome[left + 1][right - 1]);
            }
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j + k <= i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.max(dp[i - 1], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}
