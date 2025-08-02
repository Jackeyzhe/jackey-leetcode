package hot;

import easy.list.single.ListNode;

public class RemoveNthFromEnd_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        ListNode left = dummyNode;
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummyNode.next;
    }
}
