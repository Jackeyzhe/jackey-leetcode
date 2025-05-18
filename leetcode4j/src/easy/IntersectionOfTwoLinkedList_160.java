package easy;

import easy.list.single.ListNode;

public class IntersectionOfTwoLinkedList_160 {

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeB1 = new ListNode(2);
        ListNode nodeC1 = new ListNode(3);
        nodeA1.next = nodeC1;
        nodeB1.next = nodeC1;
        IntersectionOfTwoLinkedList_160 solution = new IntersectionOfTwoLinkedList_160();
        ListNode result = solution.getIntersectionNode(nodeA1, nodeB1);
        System.out.println(result.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
     }
}
