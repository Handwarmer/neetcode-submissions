class PrefixTree {
    PrefixTree[] next = new PrefixTree[26];
    boolean end = false;
    public PrefixTree() {
         
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        PrefixTree cur = this;
        for (char c : cs) {
            if (cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new PrefixTree();
            cur = cur.next[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        char[] cs = word.toCharArray();
        PrefixTree cur = this;
        for (char c : cs) {
            if (cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        PrefixTree cur = this;
        for (char c : cs) {
            if (cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
        }
        return true;
    }
}
