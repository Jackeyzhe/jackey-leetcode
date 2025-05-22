package medium;

import common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInBST_230 {

    public static void main(String[] args) {
        KthSmallestElementInBST_230 solution = new KthSmallestElementInBST_230();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println(solution.kthSmallest(root, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
