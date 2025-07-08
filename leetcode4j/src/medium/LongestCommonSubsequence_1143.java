package medium;

public class LongestCommonSubsequence_1143 {

    public static void main(String[] args) {
        LongestCommonSubsequence_1143 solution = new LongestCommonSubsequence_1143();
        String text1 = "abcde";
        String text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) != text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[m][n];
    }
}
