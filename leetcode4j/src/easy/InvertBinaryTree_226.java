package easy;

import common.tree.TreeNode;

public class InvertBinaryTree_226 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        InvertBinaryTree_226 solution = new InvertBinaryTree_226();
        System.out.println(solution.invertTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
