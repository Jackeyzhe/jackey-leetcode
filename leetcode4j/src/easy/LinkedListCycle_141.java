package easy;

public class LinkedListCycle_141 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListCycle_141 solution = new LinkedListCycle_141();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        ListNode node4 = new ListNode(-4);
        node3.next = node4;
        node4.next = node2;

        System.out.println(solution.hasCycle(node1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
