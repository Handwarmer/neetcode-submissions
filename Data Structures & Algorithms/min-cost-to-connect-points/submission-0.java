class Solution {
    public int minCostConnectPoints(int[][] points) {
        UnionFind uf = new UnionFind(points.length);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < points.length; i ++) {
            for (int j = i+1; j < points.length; j ++) {
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                pq.add(new int[]{i, j, dist});
            }
        }
        int ans = 0;
        while(!pq.isEmpty() && uf.count > 1) {
            int[] cur = pq.poll();
            if (uf.union(cur[0], cur[1]))
                ans += cur[2];
        }
        return ans;
    }

    class UnionFind {
        int[] parent;
        int count;
        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i ++)
                parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            parent[px] = py;
            count --;
            return true;
        }
    }
}
