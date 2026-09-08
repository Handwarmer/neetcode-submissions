class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] preq : prerequisites) {
            m.putIfAbsent(preq[1], new ArrayList<>());
            m.get(preq[1]).add(preq[0]);
            indegree[preq[0]] ++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i ++) {
            if (indegree[i] == 0) q.add(i);
        }
        int completed = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            completed ++;
            ans.add(cur);
            for (int next : m.getOrDefault(cur, new ArrayList<>())) {
                if (-- indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        if (completed != numCourses) return new int[0];
        int[] ansArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }
}
