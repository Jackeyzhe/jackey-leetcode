package hot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 solution = new LengthOfLongestSubstring_3();
        String s = "tmmzuxt";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int right = -1;
        int ans = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}
