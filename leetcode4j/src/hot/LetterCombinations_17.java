package hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations_17 {

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrace(combinations, phoneMap, digits, 0, new StringBuilder());

        return combinations;
    }

    private void backtrace(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            combinations.add(stringBuilder.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                stringBuilder.append(letters.charAt(i));
                backtrace(combinations, phoneMap, digits, index + 1, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }
}
