package medium;

import common.tree.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView_199 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        BinaryTreeRightSideView_199 solution = new BinaryTreeRightSideView_199();
        System.out.println(solution.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightMostAtDepth = new HashMap<>();

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);
        int maxDepth = -1;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);
                if (!rightMostAtDepth.containsKey(depth)) {
                    rightMostAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            rightView.add(rightMostAtDepth.get(i));
        }
        return rightView;
    }
}
