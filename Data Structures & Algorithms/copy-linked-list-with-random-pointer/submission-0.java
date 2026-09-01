/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> m = new HashMap<>();
        Node cur = head, cpyCur = null;
        while (cur != null) { //先创建拷贝
            cpyCur = new Node(cur.val);
            m.put(cur, cpyCur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) { //再连接next和random
            m.get(cur).random = m.get(cur.random);
            m.get(cur).next = m.get(cur.next);
            cur = cur.next;
        }
        return m.get(head);
    }
}
