package hot100.linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printListNode(ListNode node) {
        while (node.next != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println(node.val);
    }

    public static ListNode generateListNode() {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        for (int i = 1; i <= 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return dummyHead.next;
    }

    public static ListNode generateListNode(int[] nums) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        for (int i : nums) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        return null;
    }
}

