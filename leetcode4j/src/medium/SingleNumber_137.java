package medium;

public class SingleNumber_137 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,2};
        SingleNumber_137 solution = new SingleNumber_137();
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int twos = 0;
        int ones = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
