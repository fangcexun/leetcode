package hot100.linkedList;

import static hot100.linkedList.ListNode.printListNode;

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1, lists[0]);

        for (int i = 1; i < lists.length; i++) {
            dummy = mergeLists(dummy.next, lists[i]);
        }
        return dummy.next;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            } else {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
        }

        while (l1 != null) {
            curr.next = l1;
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            curr.next = l2;
            curr = curr.next;
            l2 = l2.next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        LC23 lc23 = new LC23();

        ListNode l1 = ListNode.generateList(new int[]{1,2,3,4,5});
        ListNode l2 = ListNode .generateList(new int[]{1,3,9});

        ListNode[] nodeList = new ListNode[2];
        nodeList[0] = l1;
        nodeList[1] = l2;

        ListNode listNode = lc23.mergeKLists(nodeList);
        printListNode(listNode);
    }
}

class LC23MergeSort {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = sort(0, lists.length - 1, lists);
        return dummy == null ? null : dummy.next;
    }

    public ListNode sort(int left, int right, ListNode[] lists) {
        if (left == right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        sort(left, mid, lists);
        sort(mid + 1, right, lists);
        return mergeLists(left, right, lists);
    }

    private ListNode mergeLists(int left, int right, ListNode[] lists) {
        ListNode l1 = lists[left];
        ListNode l2 = lists[right];

        ListNode dummy = new ListNode(-1, null);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            } else {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
        }

        while (l1 != null) {
            curr.next = l1;
            curr = curr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            curr.next = l2;
            curr = curr.next;
            l2 = l2.next;
        }
        return dummy;
    }
}
