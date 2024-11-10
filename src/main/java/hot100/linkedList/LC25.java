package hot100.linkedList;

import static hot100.linkedList.ListNode.printListNode;

public class LC25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;

        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode front = dummy;

        for (int time = 0; time < length / k; time++) {
            front = rotate(front, k);
        }

        return dummy.next;
    }

    private static ListNode rotate(ListNode front, int time) {
        ListNode prev = front.next;
        ListNode curr = prev.next;

        for (int i = 0; i < time - 1; i++) {
            prev.next = curr.next;
            curr.next = front.next;
            front.next = curr;

            curr = prev.next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        printListNode(reverseKGroup(head, 2));

    }
}


