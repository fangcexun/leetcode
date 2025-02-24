package hot100.linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printListNode(ListNode node) {
        if (node == null) {
            return;
        }
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

    public static ListNode generateList(int[] list) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        for (int num : list) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummyHead.next;
    }
}

