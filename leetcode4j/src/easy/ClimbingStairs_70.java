package easy;

public class ClimbingStairs_70 {

    public static void main(String[] args) {
        ClimbingStairs_70 solution = new ClimbingStairs_70();
        int n = 3;
        System.out.println(solution.climbStairs(n));
    }

    public int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
