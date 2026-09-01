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
    public void reorderList(ListNode head) {
        ListNode mid = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next; fast = fast.next;
        }
        mid = slow.next; slow.next = null;
        ListNode h1 = head, h2 = reverse(mid), tmp = null, tmp2 = null;
        while (h1 != null && h2 != null) {
            tmp = h1.next;
            h1.next = h2;
            h1 = tmp;
            tmp2 = h2.next;
            h2.next = h1;
            h2 = tmp2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head, tmp = head, prev = null;
        while (cur != null) {
            tmp = cur;
            cur = cur.next;
            tmp.next = prev;
            prev = tmp;
        }
        return prev;
    }
}
