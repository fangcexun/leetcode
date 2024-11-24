package hot100.linkedList;

import static hot100.linkedList.ListNode.printListNode;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = head;
        ListNode curr = prev.next;

        while (curr != null) {
            prev.next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;

            curr = prev.next;
        }

        return dummy.next;
    }
}
