package medium;

import java.util.*;

public class GroupAnagrams_49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams_49 solution = new GroupAnagrams_49();
        List<List<String>> ans = solution.groupAnagrams(strs);
        System.out.println(ans);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            Integer index = map.get(sortStr);
            if (index == null) {
                index = ans.size();
                map.put(sortStr, index);
                List<String> res = new ArrayList<>();
                res.add(str);
                ans.add(res);
            } else {
                List<String> res = ans.get(index);
                res.add(str);
            }
        }
        return ans;
    }
}
