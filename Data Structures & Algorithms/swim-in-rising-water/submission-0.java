class Solution {
    // dijkstra
    public int swimInWater(int[][] grid) {
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        visited[0][0] = true;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], maxSeen = cur[2];
            if (r == grid.length-1 && c == grid[0].length-1) return maxSeen;
            for (int[] d : dir) {
                int nr = r+d[0], nc = c+d[1];
                if (nr<0||nr==grid.length||nc<0||nc==grid[0].length) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                pq.add(new int[]{nr, nc, Math.max(maxSeen, grid[nr][nc])});
            }
        }
        return -1;
    }
}
