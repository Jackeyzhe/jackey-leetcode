package easy;

import common.tree.TreeNode;

public class MaximumDepthOfBinaryTree_104 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        MaximumDepthOfBinaryTree_104 solution = new MaximumDepthOfBinaryTree_104();
        System.out.println(solution.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
