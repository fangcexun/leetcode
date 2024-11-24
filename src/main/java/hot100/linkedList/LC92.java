package hot100.linkedList;

import org.omg.CORBA.MARSHAL;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fakeDummy = null;
        ListNode curr = dummy;
        ListNode prev = null;

        int index = 0;

        while (index <= left) {
            if (index == left - 1) {
                fakeDummy = curr;
            }

            if (index == left) {
                prev = curr;
            }
            curr = curr.next;
            index++;
        }

        while (index <= right) {
            prev.next = curr.next;
            curr.next = fakeDummy.next;
            fakeDummy.next = curr;

            curr = prev.next;
            index++;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LC92 lc92 = new LC92();
        ListNode head = ListNode.generateListNode();
        ListNode.printListNode(head);
        ListNode.printListNode(lc92.reverseBetween(head, 2, 4));

    }
}
