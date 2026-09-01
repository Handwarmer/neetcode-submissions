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
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null, tmp = null;
        while (cur != null) {
            tmp = cur;
            cur = cur.next;
            tmp.next = prev;
            prev = tmp;
        }
        return prev;
    }
}
