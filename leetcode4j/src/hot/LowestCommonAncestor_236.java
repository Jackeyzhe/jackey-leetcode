package hot;

import common.tree.TreeNode;

public class LowestCommonAncestor_236 {

    TreeNode ans;

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
        if ((lson && rson) || ((root.val == q.val || root.val == p.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == q.val || root.val == p.val);
    }
}
