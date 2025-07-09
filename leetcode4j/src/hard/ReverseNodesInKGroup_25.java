package hard;

import easy.list.single.ListNode;

public class ReverseNodesInKGroup_25 {

    public static void main(String[] args) {
        ReverseNodesInKGroup_25 solution = new ReverseNodesInKGroup_25();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 3;
        ListNode result = solution.reverseKGroup(head, k);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while (pre.next != null) {
            ListNode post = rotate(pre, k);
            if (post == null) {
                rotate(pre, k);
                break;
            } else {
                pre = post;
            }
        }
        return dummy.next;
    }

    private ListNode rotate(ListNode pre, int k) {
        ListNode cur = pre.next;
        int i = 1;
        for (; i < k && cur != null && cur.next != null; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return i == k ? cur : null;
    }
}
