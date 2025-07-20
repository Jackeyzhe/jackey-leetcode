package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams_438 {

    public static void main(String[] args) {
        FindAnagrams_438 solution = new FindAnagrams_438();
        String s = "abab";
        String p = "ab";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);
    }

    public List<Integer> findAnagrams(String s, String p) {
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String pStr = new String(pArr);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int right = i + p.length();
            String sub = s.substring(i, right);
            char[] arr = sub.toCharArray();
            Arrays.sort(arr);
            String subStr = new String(arr);
            if (pStr.equals(subStr)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
