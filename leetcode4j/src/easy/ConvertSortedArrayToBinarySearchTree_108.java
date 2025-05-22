package easy;

import common.tree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree_108 {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        ConvertSortedArrayToBinarySearchTree_108 solution = new ConvertSortedArrayToBinarySearchTree_108();
        TreeNode result = solution.sortedArrayToBST(nums);
        System.out.println(result);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
