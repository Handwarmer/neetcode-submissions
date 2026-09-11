class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 不用Integer.MAX_VALUE, 防止+w后溢出变成负值
        final int INF = 1_000_000_000;
        // dp[i][v] = 从 src 出发、最多用 i 条边（= i-1 次中转）到达 v 的最小花费
        int[][] dp = new int[k+1+1][n-1+1]; //k次中转，等于k+1条边 
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][src] = 0;                       // base: 0 条边时只有起点花费为 0
        
        for (int i = 1; i <= k + 1; i++) {    // 逐层放开一条边的额度
            dp[i][src] = 0;                   // 起点在任何边数上限下都是 0
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                dp[i][v] = Math.min(dp[i][v], // 本轮已处理的其它入边给 v 算出的当前最优，保留不被覆盖
                Math.min(
                    dp[i - 1][u] + w,   // 用上一层到 u 的结果，再走一条 u->v
                    dp[i - 1][v]));     // 或不用这条新边，上一层就已到 v
            }   
        }           
        return dp[k + 1][dst] >= INF ? -1 : dp[k + 1][dst];
    }
}


// class Solution {
//     Map<Integer, List<int[]>> m = new HashMap<>();
//     int dst;
//     Integer[][] memo;
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         this.dst = dst;
//         memo = new Integer[n][k + 2];        // stopsLeft 范围 0..k+1
//         for (int[] f : flights) {
//             m.computeIfAbsent(f[0], key -> new ArrayList<>()).add(new int[]{f[1],f[2]});
//         }
//         int ans = dfs(src, k+1);
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
//     // 从 cur 到 dst、最多再走 stopsLeft 条边的最小花费
//     int dfs(int cur, int stopsLeft) {
//         if (cur == dst) return 0;
//         if (stopsLeft == 0) return Integer.MAX_VALUE;
//         if (memo[cur][stopsLeft] != null) return memo[cur][stopsLeft];
//         int best = Integer.MAX_VALUE;
//         for (int[] next : m.getOrDefault(cur, new ArrayList<>())) {
//             int sub = dfs(next[0], stopsLeft - 1);
//             if (sub != Integer.MAX_VALUE) best = Math.min(best, sub + next[1]);
//         }
//         return memo[cur][stopsLeft] = best;
//     }
// }
