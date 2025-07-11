package hard;

public class MedianOfTwoSortedArray_4 {

    public static void main(String[] args) {
        MedianOfTwoSortedArray_4 solution = new MedianOfTwoSortedArray_4();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        a[0] = b[0] = Integer.MIN_VALUE;
        a[m + 1] = b[n + 1] = Integer.MAX_VALUE;
        System.arraycopy(nums1, 0, a, 1, m);
        System.arraycopy(nums2, 0, b, 1, n);

        int i = 0;
        int j = (m + n + 1) / 2;
        while (true) {
            if (a[i] <= b[j + 1] && a[i + 1] > b[j]) {
                int max1 = Math.max(a[i], b[j]);
                int min2 = Math.min(a[i + 1], b[j + 1]);
                return (m + n) % 2 > 0 ? max1 : (max1 + min2) / 2.0;
            }
            i++;
            j--;
        }
    }
}
