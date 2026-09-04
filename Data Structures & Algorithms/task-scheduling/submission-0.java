class Solution {
    public int leastInterval(char[] tasks, int n) {
        // each int[] has {cooldown, freq, taskNum}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Deque<int[]> q = new ArrayDeque<>();
        int[] freq = new int[26];
        for (char t : tasks) {
            int ti = t - 'A';
            freq[ti] ++;
        }
        for (int i = 0; i < freq.length; i ++) {
            if (freq[i] > 0) pq.add(new int[]{0, freq[i], i});
        }
        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time ++;
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (--cur[1] > 0) {
                    cur[0] = time + n;
                    q.add(cur);
                }
            }
            if (!q.isEmpty()) {
                if (q.peek()[0] <= time) {
                    pq.add(q.poll());
                }
            }
        }
        return time;
    }
}
