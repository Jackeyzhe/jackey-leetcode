package easy;

public class NumberOf1Bits_191 {

    public static void main(String[] args) {
        NumberOf1Bits_191 solution = new NumberOf1Bits_191();
        int n = 128;
        System.out.println(solution.hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }
}
