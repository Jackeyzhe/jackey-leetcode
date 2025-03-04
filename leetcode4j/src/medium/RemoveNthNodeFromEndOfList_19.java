package medium;

import easy.list.single.ListNode;

public class RemoveNthNodeFromEndOfList_19 {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList_19 solution = new RemoveNthNodeFromEndOfList_19();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution.removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode first = head;
        ListNode second = dummyNode;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyNode.next;
    }
}
