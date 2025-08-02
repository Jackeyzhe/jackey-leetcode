package hot;

import easy.list.single.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsPalindrome_234 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = vals.size() - 1;
        while (left < right) {
            if (!Objects.equals(vals.get(left), vals.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
