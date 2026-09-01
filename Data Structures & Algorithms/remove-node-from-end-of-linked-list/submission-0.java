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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(); dummy.next = head; //搞个dummy，方便处理删head的情况
        ListNode p1 = dummy, p2 = dummy; 
        while (n-- > 0) { // p2先走n步
            p2 = p2.next;
        }
        // 然后p1，p2一起走。p1停在最后一个（而不是null）时, p1就会落在要被删的节点前一个了
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode toBeRemoved = p1.next;
        p1.next = toBeRemoved.next;
        return dummy.next;
    }
}
