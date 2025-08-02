package hot;

import common.tree.TreeNode;

public class diameterOfBinaryTree_543 {

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int depth1 = helper(root.left) + 1;
        int depth2 = helper(root.right) + 1;
        ans = Math.max(ans, depth1 + depth2);
        return Math.max(depth1, depth2);
    }
}
