class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int ans = 0;
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[0].length; c ++) {
                if (grid[r][c] == '1') {
                    ans ++;
                    dfs(r, c);
                }
            }
        }
        return ans;
    }
    void dfs(int r, int c) {
        if (r<0||r==grid.length||c<0||c==grid[0].length) return;
        if (grid[r][c] != '1') return;
        grid[r][c] = '2';
        for (int[] d : dir) {
            dfs(r+d[0],c+d[1]);
        }
    }
}
