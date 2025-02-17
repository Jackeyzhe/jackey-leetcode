package easy;

public class SqrtX_69 {

    public static void main(String[] args) {
        SqrtX_69 solution = new SqrtX_69();
        int x = 9;
        System.out.println(solution.mySqrt(x));
    }

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
