class Solution {
    boolean ans = false;
    char[] w;
    char[][] board;
    int[][] pos = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        w = word.toCharArray();
        this.board = board;
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c < board[0].length; c ++) {
                backtrack(0, r, c, new HashSet<>());
            }
        }
        return ans;
    }
    void backtrack(int i, int r, int c, Set<List<Integer>> visited) {
        if (ans) return;
        if (r<0||r==board.length||c<0||c==board[0].length) return;
        if (visited.contains(List.of(r, c))) return;
        if (board[r][c] != w[i]) return;
        if (i == w.length - 1) {
            ans = true;
            return;
        }
        visited.add(Arrays.asList(r, c));
        for (int[] po : pos) {
            backtrack(i+1, r+po[0], c+po[1], visited);
        }
        visited.remove(Arrays.asList(r, c));
    }
}
