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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {return Integer.compare(a.val,b.val);});
        for (ListNode n : lists) {
            if (n != null) pq.add(n);
        }
        ListNode head = new ListNode(), cur = head;
        while (!pq.isEmpty()) {
            ListNode curN = pq.poll();
            cur.next = curN;
            cur = cur.next;
            if (curN.next != null) pq.add(curN.next);
        }
        return head.next;
    }
}
