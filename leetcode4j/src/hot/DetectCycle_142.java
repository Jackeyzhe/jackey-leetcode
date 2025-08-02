package hot;

import easy.list.single.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle_142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
