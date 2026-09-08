class Solution {
    Map<Integer, Set<Integer>> m = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    boolean hasCycle = false;
    public boolean validTree(int n, int[][] edges) {
        for (int[] e : edges) {
            m.putIfAbsent(e[0], new HashSet<>());
            m.get(e[0]).add(e[1]);
            m.putIfAbsent(e[1], new HashSet<>());
            m.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        return !hasCycle && visited.size() == n;
    }
    void dfs(int cur, int parent) {
        if (!visited.add(cur)) hasCycle = true;
        if (hasCycle) return;
        for (int nei : m.getOrDefault(cur, new HashSet<>())) {
            if (nei == parent) continue;
            dfs(nei, cur);
        }
    }
}
