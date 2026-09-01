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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(), cur = start;
        while (cur != null) {
            if (l1 == null && l2 == null) {
                cur = null;
                break;
            }
            if (l1 == null) {
                cur.next = l2;
                break;
            }
            else if (l2 == null) {
                cur.next = l1;
                break;
            }
            else {
                if (l1.val > l2.val) {
                    cur.next = l2;
                    l2 = l2.next;
                } else {
                    cur.next = l1;
                    l1 = l1.next;
                }
            }
            cur = cur.next;
        }
        return start.next;
    }
}