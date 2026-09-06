class WordDictionary {

    Trie trie = new Trie();
    public WordDictionary() {

    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.find(word);
    }

    class Trie {
        Trie[] next = new Trie[26];
        boolean end = false;
        void add(String word) {
            Trie cur = this;
            char[] cs = word.toCharArray();
            for (char c : cs) {
                if (cur.next[c - 'a'] == null)
                    cur.next[c - 'a'] = new Trie();
                cur = cur.next[c - 'a'];
            }
            cur.end = true;
        }
        boolean find(String word) {
            return find(0, word.toCharArray(), this);
        }
        boolean find(int i, char[] cs, Trie cur) {
            if (cur == null) return false;
            if (i == cs.length) return cur.end;
            if (cs[i] == '.') {
                for (Trie t : cur.next) {
                    if (t == null) continue;
                    if (find(i+1, cs, t)) return true;
                }
                return false;
            }
            return find(i+1, cs, cur.next[cs[i] - 'a']);
        }
    }
}
