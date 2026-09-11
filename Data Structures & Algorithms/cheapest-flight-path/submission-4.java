class Solution {
    Map<Integer, List<int[]>> m = new HashMap<>();
    int dst;
    Integer[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.dst = dst;
        memo = new Integer[n][k + 2];        // stopsLeft 范围 0..k+1
        for (int[] f : flights) {
            m.computeIfAbsent(f[0], key -> new ArrayList<>()).add(new int[]{f[1],f[2]});
        }
        int ans = dfs(src, k+1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    // 从 cur 到 dst、最多再走 stopsLeft 条边的最小花费
    int dfs(int cur, int stopsLeft) {
        if (cur == dst) return 0;
        if (stopsLeft == 0) return Integer.MAX_VALUE;
        if (memo[cur][stopsLeft] != null) return memo[cur][stopsLeft];
        int best = Integer.MAX_VALUE;
        for (int[] next : m.getOrDefault(cur, new ArrayList<>())) {
            int sub = dfs(next[0], stopsLeft - 1);
            if (sub != Integer.MAX_VALUE) best = Math.min(best, sub + next[1]);
        }
        return memo[cur][stopsLeft] = best;
    }
}
