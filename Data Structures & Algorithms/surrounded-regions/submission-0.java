class Solution {
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        UnionFind uf = new UnionFind(row * col + col);
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (board[r][c] == 'X') continue;
                if (r==0||c==0||r==row-1||c==col-1) uf.isRegion[r*col + c] = false;
                if (r>0 && board[r-1][c] == 'O') uf.union(r*col+c, (r-1)*col+c);
                if (c>0 && board[r][c-1] == 'O') uf.union(r*col+c, r*col+c-1);
            }
        }
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (uf.isRegion[uf.find(r*col+c)]) board[r][c] = 'X';
            }
        }
    }
    class UnionFind {
        int[] parent;
        boolean[] isRegion;
        public UnionFind(int n) {
            parent = new int[n];
            isRegion = new boolean[n];
            for (int i = 0; i < n; i ++) {
                parent[i] = i;
                isRegion[i] = true;
            }
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            parent[px] = py;
            isRegion[py] = isRegion[px] && isRegion[py];
        }
    }
}
