/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> m = new HashMap<>();
        Node clone = new Node(node.val);
        m.put(node, clone);
        Deque<Node> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nei : cur.neighbors) {
                if (!m.containsKey(nei)) {
                    m.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                m.get(cur).neighbors.add(m.get(nei));
            }
        }
        return clone;
    }
}