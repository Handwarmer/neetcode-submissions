class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    char[][] board;
    Trie trie = new Trie();
    List<String> res = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        for (String word : words) {
            trie.add(word);
        }
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[0].length; c ++) {
                dfs(r, c, trie);
            }
        }
        return res;
    }

    void dfs(int r, int c, Trie trie) {
        if (r<0||r==board.length||c<0||c==board[0].length) return;
        char ch = board[r][c];
        Trie next = trie.next[ch - 'a'];
        if (next == null) return;
        if (!addVisited(r, c)) return;
        sb.append(ch);
        if (next.end) {
            res.add(sb.toString());
            next.end = false;
        }
        for (int[] d : dir) {
            dfs(r + d[0], c + d[1], next);
        }
        sb.deleteCharAt(sb.length() - 1);
        removeVisited(r, c);
    }
    boolean addVisited(int r, int c) {
        return visited.add(r*board[0].length + c);
    }
    void removeVisited(int r, int c) {
        visited.remove(r*board[0].length + c);
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
                cur = cur.next[c-'a'];
            }
            cur.end = true;
        }
    }
}
