package medium;

public class BitwiseAndOfNumbersRange_201 {

    public static void main(String[] args) {
        int left = 1;
        int right = 2147483647;
        BitwiseAndOfNumbersRange_201 solution = new BitwiseAndOfNumbersRange_201();
        System.out.println(solution.rangeBitwiseAnd(left, right));
    }

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}
