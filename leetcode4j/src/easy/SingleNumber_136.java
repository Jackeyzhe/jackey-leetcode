package easy;

public class SingleNumber_136 {

    public static void main(String[] args) {
        SingleNumber_136 solution = new SingleNumber_136();
        int[] nums = new int[]{2,2,1};
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
