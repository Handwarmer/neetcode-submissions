class Solution {
    Map<String, PriorityQueue<String>> m = new HashMap<>();
    LinkedList<String> ans = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> tkt : tickets) {
            m.computeIfAbsent(tkt.get(0), k -> new PriorityQueue<>()).add(tkt.get(1));
        }
        dfs("JFK");
        return ans;
    }
    void dfs(String cur) {
        PriorityQueue<String> pq = m.get(cur);
        while (pq!=null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        ans.addFirst(cur);
    }
}
