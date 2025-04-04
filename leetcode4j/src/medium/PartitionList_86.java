package medium;

import easy.list.single.ListNode;

public class PartitionList_86 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        int x = 3;
        PartitionList_86 solution = new PartitionList_86();
        ListNode result = solution.partition(head, x);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode small = smallDummy;
        ListNode large = largeDummy;
        while (head != null) {
            if (head.val >= x) {
                large.next = head;
                large = large.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        small.next = largeDummy.next;
        large.next = null;

        return smallDummy.next;
    }
}
