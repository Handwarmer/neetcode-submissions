class Solution {
    // Dijkstra
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] t : times) {
            edges.computeIfAbsent(t[0], key -> new ArrayList<>())
                .add(new int[]{t[1], t[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n+1];
        for (int i = 0; i < dist.length; i ++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new int[]{k, 0});
        int reached = 0, ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int e = cur[0], d = cur[1];
            if (d >= dist[e]) continue;
            dist[e] = d;
            reached ++;
            ans = Math.max(d, ans);
            for (int[] nei : edges.getOrDefault(e, new ArrayList<>())) {
                pq.add(new int[]{nei[0], d+nei[1]});
            }
        }
        return reached == n ? ans : -1;
    }
}
