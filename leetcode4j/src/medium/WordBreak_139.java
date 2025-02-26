package medium;

import java.util.*;

public class WordBreak_139 {

    public static void main(String[] args) {
        WordBreak_139 solution = new WordBreak_139();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(solution.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
