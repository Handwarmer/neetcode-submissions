class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length, ans = 0;
        UnionFind uf = new UnionFind(row*col + col);
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (grid[r][c] == 0) continue;
                uf.maxSize = Math.max(uf.maxSize, 1);
                if (r > 0 && grid[r-1][c] == 1) 
                    uf.union(r*col+c, (r-1)*col+c);
                if (c > 0 && grid[r][c-1] == 1) 
                    uf.union(r*col+c, (r)*col+c-1);
            }
        }
        return uf.maxSize;
    }

    class UnionFind {
        int[] parent;
        int[] height;
        int[] size;
        int count;
        int maxSize;
        public UnionFind(int n) {
            parent = new int[n];
            height = new int[n];
            size = new int[n];
            count = n;
            maxSize = 0;
            for (int i = 0; i < n; i ++) {
                parent[i] = i;
                height[i] = 1;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            int newSize = size[px] + size[py];
            if (height[px] < height[py]) {
                parent[px] = py;
            } else if (height[px] > height[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                height[py] ++;
            }
            size[px] = newSize; size[py] = newSize;
            count --;
            maxSize = Math.max(maxSize, newSize);
        }
    }
}
