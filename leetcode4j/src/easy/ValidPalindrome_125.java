package easy;

public class ValidPalindrome_125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome_125 solution = new ValidPalindrome_125();
        System.out.println(solution.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            }
        }
        int n = stringBuilder.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(stringBuilder.charAt(left)) != Character.toLowerCase(stringBuilder.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
