class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[0].length; c ++) {
                if (grid[r][c] == 0) q.add(new int[]{r, c});
            }
        }
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int nr = cur[0]+d[0], nc = cur[1]+d[1];
                if (nr<0||nr==grid.length||nc<0||nc==grid[0].length) continue;
                if (grid[nr][nc] != 2147483647) continue;
                grid[nr][nc] = grid[cur[0]][cur[1]] + 1;
                q.add(new int[]{nr, nc});
            }
        }
    }
}
