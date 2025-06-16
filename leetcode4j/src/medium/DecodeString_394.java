package medium;

import java.util.Collections;
import java.util.LinkedList;

public class DecodeString_394 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString_394 solution = new DecodeString_394();
        String result = solution.decodeString(s);
        System.out.println(result);
    }

    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        ptr = 0;

        while (ptr < s.length()) {
            char c = s.charAt(ptr);
            if (Character.isDigit(c)) {
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (c == '[' || Character.isLetter(c)) {
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                stack.removeLast();
                int repeatTime = Integer.valueOf(stack.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                while (repeatTime-- > 0) {
                    t.append(o);
                }
                stack.addLast(t.toString());
            }
        }
        return getString(stack);
    }

    private String getDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr));
            ptr++;
        }
        return sb.toString();
    }

    private String getString(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String l : list) {
            sb.append(l);
        }
        return sb.toString();
    }
}
