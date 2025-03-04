package medium;

import easy.list.random.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {


    public static void main(String[] args) {
        CopyListWithRandomPointer_138 solution = new CopyListWithRandomPointer_138();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.random = node2;
        node1.next = node2;
        node2.random = node2;
        Node result = solution.copyRandomList(node1);
        while (result != null) {
            Integer nextVal = result.next != null ? result.next.val : null;
            Integer randomVal = result.random != null ? result.random.val : null;
            System.out.println("val=" + result.val + " next=" + nextVal + " random=" + randomVal);
            result = result.next;
        }
    }

    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node newHead = new Node(head.val);
            cachedNode.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
