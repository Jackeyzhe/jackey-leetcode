package easy;

import common.tree.TreeNode;

public class DiameterOfBinaryTree_543 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        DiameterOfBinaryTree_543 solution = new DiameterOfBinaryTree_543();
        System.out.println(solution.diameterOfBinaryTree(root));
    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
