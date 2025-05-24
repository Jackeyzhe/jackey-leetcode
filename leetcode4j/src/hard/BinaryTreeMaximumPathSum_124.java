package hard;

import common.tree.TreeNode;

public class BinaryTreeMaximumPathSum_124 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        BinaryTreeMaximumPathSum_124 solution = new BinaryTreeMaximumPathSum_124();
        int result = solution.maxPathSum(root);
        System.out.println(result);
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        int priceNewPath = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);

        return root.val + Math.max(leftGain, rightGain);
    }
}
