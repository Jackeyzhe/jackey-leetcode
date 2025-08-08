package hot;

import common.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Flatten_114 {

    public void flatten(TreeNode root) {
        List<TreeNode> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);

        int size = preOrderList.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = preOrderList.get(i - 1);
            TreeNode cur = preOrderList.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}
