package medium;

import java.util.*;

public class FindAllAnagramsInString_438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsInString_438 solution = new FindAllAnagramsInString_438();
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
