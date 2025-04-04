package easy;

public class PalindromeNumber_9 {

    public static void main(String[] args) {
        PalindromeNumber_9 solution = new PalindromeNumber_9();
        int x = 21;
        System.out.println(solution.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNumber = 0;
        while (x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseNumber || x == reverseNumber / 10;
    }
}
