/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = (start + end) / 2;
        return mergeTwo(merge(lists, start, mid), merge(lists, mid+1, end));
    }

    private ListNode mergeTwo(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        ListNode head = new ListNode(), cur = head;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                cur.next = n2;
                n2 = n2.next;
            } else {
                cur.next = n1;
                n1 = n1.next;
            }
            cur = cur.next;
        }
        cur.next = n1 == null ? n2 : n1;
        return head.next;
    }
}
