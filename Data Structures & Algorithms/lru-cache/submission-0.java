class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        Node() {}
    }

    Map<Integer, Node> m = new HashMap<>();
    Node head = new Node(), tail = new Node();
    int capacity, curCap = 0;

    public LRUCache(int capacity) {
        head.next = tail; tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!m.containsKey(key)) return -1;
        detachFromList(key);
        insertAfterHead(m.get(key));
        return m.get(key).val;
    }
    
    public void put(int key, int value) {
        if (!m.containsKey(key)) {
            Node cur = new Node(key, value);
            m.put(key, cur);
            curCap ++;
        } else {
            detachFromList(key);
            m.get(key).val = value;
        }
        insertAfterHead(m.get(key));
        if (curCap > capacity) {
            removeFromTail();
            curCap --;
        }
    }

    private void detachFromList(int key) {
        Node cur = m.get(key);
        Node prev = cur.prev, next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertAfterHead(Node n) {
        Node tmp = head.next;
        head.next = n;
        n.next = tmp;
        n.prev = head;
        tmp.prev = n;
    }

    private void removeFromTail() {
        Node tmp = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        m.remove(tmp.key);
    }
}
