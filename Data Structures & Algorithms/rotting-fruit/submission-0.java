class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int goodCount = 0;
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[0].length; c ++) {
                if (grid[r][c] == 2)
                    q.add(new int[]{r, c});
                else if (grid[r][c] == 1)
                    goodCount ++;
            }
        }
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int ans = 2;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr<0||nr==grid.length||nc<0||nc==grid[0].length) continue;
                if(grid[nr][nc]!=1) continue;
                goodCount --;
                grid[nr][nc] = grid[cur[0]][cur[1]] + 1;
                ans = Math.max(ans, grid[nr][nc]);
                q.add(new int[]{nr, nc});
            }
        }
        
        return (goodCount == 0) ? ans - 2 : -1;
    }
}
