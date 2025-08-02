package hot;

import easy.list.single.ListNode;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA;
        Set<ListNode> set = new HashSet<>();
        while (list1 != null) {
            set.add(list1);
            list1 = list1.next;
        }
        ListNode list2 = headB;
        while (list2 != null) {
            if (set.contains(list2)) {
                return list2;
            }
            list2 = list2.next;
        }
        return null;
    }
}
