package medium;

import common.tree.TreeNode;

public class ValidateBinarySearchTree_98 {

    public static void main(String[] args) {
        ValidateBinarySearchTree_98 solution = new ValidateBinarySearchTree_98();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(solution.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

}
