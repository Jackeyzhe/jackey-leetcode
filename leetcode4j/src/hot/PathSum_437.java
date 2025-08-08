package hot;

import common.tree.TreeNode;

public class PathSum_437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        ret += rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int rootSum(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        int ret = 0;
        int val = node.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(node.left, targetSum - val);
        ret += rootSum(node.right, targetSum - val);
        return ret;
    }
}
