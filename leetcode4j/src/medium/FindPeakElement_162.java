package medium;

public class FindPeakElement_162 {

    public static void main(String[] args) {
        FindPeakElement_162 solution = new FindPeakElement_162();
        int[] nums = new int[]{1,2,3,1};
        int res = solution.findPeakElement(nums);
        System.out.println(res);
    }

    public int findPeakElement(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[res]) {
                res = i;
            }
        }
        return res;
    }
}
