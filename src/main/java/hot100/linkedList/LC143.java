package hot100.linkedList;

/**
 * @author xunfangce
 * @create 2024/12/8
 */
public class LC143 {
    /**
     * 这道题可以拆解为 找到链表中点 LC876，翻转单链表 LC206，合并两个有序链表 LC21
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode middleNode = findMiddleNode(head);

        ListNode list1 = head;
        ListNode list2 = revert(middleNode.next);

        middleNode.next = null;

        ListNode curr = new ListNode(-1, head);

        while (list1 != null && list2 != null) {
            curr.next = list1;
            list1 = list1.next;

            curr.next.next = list2;
            list2 = list2.next;

            curr = curr.next.next;
        }

        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
        }

        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
        }

    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode revert(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = head;
        ListNode curr = prev.next;

        while (curr != null) {
            prev.next =  curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generateListNode(new int[]{1});
        LC143 lc143 = new LC143();

        lc143.reorderList(head);
        ListNode.printListNode(head);
    }
}
