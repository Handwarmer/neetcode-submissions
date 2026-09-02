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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode groupPrev = dummyHead; //当前group的前一个node
        while (true) {
            ListNode groupTail = groupPrev; //当前group的最后一个node
            ListNode groupHead = groupPrev.next; //当前group的第一个node
            for (int i = 0; i < k && groupTail != null; i ++) {
                groupTail = groupTail.next;
            }
            if (groupTail == null) break;
            ListNode groupNext = groupTail.next;//下一个group的第一个node
            // 翻转 groupHead 到 groupTail
            ListNode prev = groupNext, cur = groupHead;
            //当cur==groupNext时，说明当前范围的已经reverse完了
            while (cur != groupNext) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            //翻转完后的list，groupTail变新的头，缝回groupPrev.next上
            groupPrev.next = groupTail;
            //翻转完后，groupHead变新的尾巴，作为下次循环的groupPrev
            groupPrev = groupHead;
        }
        return dummyHead.next;
    }
}
