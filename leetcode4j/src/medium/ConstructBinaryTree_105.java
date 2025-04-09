package medium;

import common.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree_105 {

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        ConstructBinaryTree_105 solution = new ConstructBinaryTree_105();
        TreeNode node = solution.buildTree(preorder, inorder);
        System.out.println(node.val);
    }

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int preorderRoot = preorderLeft;
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int subLeftSize = inorderRoot - inorderLeft;
        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + subLeftSize, inorderLeft, inorderRoot - 1);
        root.right = myBuildTree(preorder, inorder, preorderLeft + subLeftSize + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }
}
