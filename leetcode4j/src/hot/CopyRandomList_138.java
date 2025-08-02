package hot;

import easy.list.random.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList_138 {
    Map<Node, Node> cached = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cached.containsKey(head)) {
            Node newHead = new Node(head.val);
            cached.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cached.get(head);
    }
}
