package medium;

import common.tree.TreeNode;

public class LowestCommonAncestorOfBinaryTree_236 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, null, new TreeNode(6)), new TreeNode(1));
        LowestCommonAncestorOfBinaryTree_236 solution = new LowestCommonAncestorOfBinaryTree_236();
        TreeNode result = solution.lowestCommonAncestor(root, new TreeNode(6), new TreeNode(1));
        System.out.println(result.val);
    }

    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

}
