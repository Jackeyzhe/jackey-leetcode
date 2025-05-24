package medium;

import common.tree.TreeNode;

public class PathSum_437 {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        // [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        TreeNode root = new TreeNode(1000000000, new TreeNode(1000000000, new TreeNode(294967296, new TreeNode(1000000000, new TreeNode(1000000000, new TreeNode(1000000000), null), null), null), null), null);
        PathSum_437 solution = new PathSum_437();
        int targetSum = 0;
        int result = solution.pathSum(root, targetSum);
        System.out.println(result);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int rootSum(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }

        int val = root.val;
        if (val == targetSum) {
           ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
