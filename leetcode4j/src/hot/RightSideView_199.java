package hot;

import common.tree.TreeNode;

import java.util.*;

public class RightSideView_199 {

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightMostValueAtDepth = new HashMap<>();
        int maxDepth = -1;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Integer depth = depthStack.pop();

            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);

                if (!rightMostValueAtDepth.containsKey(depth)) {
                    rightMostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            rightView.add(rightMostValueAtDepth.get(i));
        }
        return rightView;
    }
}
