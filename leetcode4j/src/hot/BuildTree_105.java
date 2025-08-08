package hot;

import common.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
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
