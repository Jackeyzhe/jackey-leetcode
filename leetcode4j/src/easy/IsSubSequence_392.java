package easy;

public class IsSubSequence_392 {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        IsSubSequence_392 solution = new IsSubSequence_392();
        System.out.println(solution.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
