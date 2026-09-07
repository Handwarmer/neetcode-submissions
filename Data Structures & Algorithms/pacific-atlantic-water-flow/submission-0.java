class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Deque<int[]> pq = new ArrayDeque<>(), aq = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        int row = heights.length, col = heights[0].length;
        //both[r][c] = [isPacificConnected, isAtlanticConnected]
        boolean[][][] both = new boolean[row][col][2];
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (r == 0 || c == 0) {
                    both[r][c][0] = true;
                    pq.add(new int[]{r, c});
                }
                if (r == row-1 || c == col-1) {
                    both[r][c][1] = true;
                    aq.add(new int[]{r, c});
                }
            }
        }
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : dir) {
                int nr = r+d[0], nc = c+d[1];
                if(nr<0||nr==row||nc<0||nc==col) continue;
                if(heights[r][c]>heights[nr][nc]) continue;
                if(both[nr][nc][0]) continue;
                both[nr][nc][0] = true;
                pq.add(new int[]{nr, nc});
            }
        }
        while(!aq.isEmpty()) {
            int[] cur = aq.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : dir) {
                int nr = r+d[0], nc = c+d[1];
                if(nr<0||nr==row||nc<0||nc==col) continue;
                if(heights[r][c]>heights[nr][nc]) continue;
                if(both[nr][nc][1]) continue;
                both[nr][nc][1] = true;
                aq.add(new int[]{nr, nc});
            }
        }
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (both[r][c][0] && both[r][c][1]) ans.add(List.of(r, c));
            }
        }
        return ans;
    }
}
