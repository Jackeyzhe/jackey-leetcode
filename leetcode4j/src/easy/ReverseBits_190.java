package easy;

public class ReverseBits_190 {

    public static void main(String[] args) {
        int n = 43261596;
        ReverseBits_190 solution = new ReverseBits_190();
        System.out.println(solution.reverseBits(n));
    }

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n !=0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
