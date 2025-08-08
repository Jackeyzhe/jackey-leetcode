package hot;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest_230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        handle(root, inOrder);
        return inOrder.get(k - 1);
    }

    private void handle(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        handle(node.left, list);
        list.add(node.val);
        handle(node.right, list);
    }
}
