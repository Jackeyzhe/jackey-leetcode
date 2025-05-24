package medium;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList_114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5));
        FlattenBinaryTreeToLinkedList_114 solution = new FlattenBinaryTreeToLinkedList_114();
        solution.flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode curr = list.get(i);
            pre.left = null;
            pre.right = curr;
        }
    }

    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
