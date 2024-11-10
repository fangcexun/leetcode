package hot100.linkedList;

import static hot100.linkedList.ListNode.printListNode;

public class LC206 {

    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        int length = 0;
        ListNode curr = dummy;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        if (length <= 1) {
            return head;
        }

        ListNode prev = dummy.next;
        curr = prev.next;

        for (int i = 0; i < length - 1; i++) {
            insert(dummy, prev, curr);
            curr = prev.next;
        }
        return dummy.next;
    }
    private static void insert(ListNode dummy, ListNode prev, ListNode curr) {
        prev.next = curr.next;
        curr.next = dummy.next;
        dummy.next = curr;
        // 下面的代码是错误的，在方法中 curr 局部变量指向了 prev.next，但实际上没有对外面的 curr 进行更改
        curr = prev.next;
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

        ListNode newHead = reverseList(head);
        printListNode(newHead);
    }

}
