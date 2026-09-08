class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> m = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] preq : prerequisites) {
            m.putIfAbsent(preq[1], new HashSet<>());
            m.get(preq[1]).add(preq[0]);
            indegree[preq[0]] ++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i ++) {
            if (indegree[i] == 0) q.add(i);
        }
        int completed = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            completed ++;
            for (int next : m.getOrDefault(cur, new HashSet<>())) {
                if (-- indegree[next] == 0) q.add(next);
            }
        }
        return completed == numCourses;
    }
}
