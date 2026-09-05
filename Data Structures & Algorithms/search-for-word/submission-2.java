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
                backtrack(0, r, c);
            }
        }
        return ans;
    }
    void backtrack(int i, int r, int c) {
        if (ans) return;
        if (r<0||r==board.length||c<0||c==board[0].length) return;
        if (board[r][c] != w[i]) return;
        if (i == w.length - 1) {
            ans = true;
            return;
        }
        char tmp = board[r][c];
        board[r][c] = '#'; //用board来标记visited。改成#来表示已经走过了
        //在下一层backtrack中如果走到了已走过的格子，因为w[i]时候任何都不会等于#
        //就直接返回了
        for (int[] po : pos) {
            backtrack(i+1, r+po[0], c+po[1]);
        }
        board[r][c] = tmp; //把visited重置
    }
}
