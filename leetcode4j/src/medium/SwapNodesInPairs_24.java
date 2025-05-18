package medium;

import easy.list.single.ListNode;

public class SwapNodesInPairs_24 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        SwapNodesInPairs_24 solution = new SwapNodesInPairs_24();
        ListNode result = solution.swapPairs(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
