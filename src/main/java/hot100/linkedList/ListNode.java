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
}

