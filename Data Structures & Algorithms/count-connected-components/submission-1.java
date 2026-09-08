class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        return uf.count;
    }
    class UnionFind {
        int[] parent;
        int count;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0;i < n; i ++)
                parent[i] = i;
            count = n;
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x), py = find(y);
            if(px == py) return;
            parent[px] = py;
            count --;
        }
    }
}
