package medium;

public class PowXN_50 {

    public static void main(String[] args) {
        PowXN_50 solution = new PowXN_50();
        int n = 10;
        double x = 2.0;
        System.out.println(solution.myPow(x, n));
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
