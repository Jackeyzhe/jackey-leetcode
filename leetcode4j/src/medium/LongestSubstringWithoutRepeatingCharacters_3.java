package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters_3 solution = new LongestSubstringWithoutRepeatingCharacters_3();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int rk = -1;
        Set<Character> occ = new HashSet<>();
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
