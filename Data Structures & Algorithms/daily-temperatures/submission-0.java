class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> q = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i ++) {
            int t = temperatures[i];
            while (!q.isEmpty() && q.peek()[0] < t) {
                int[] top = q.pop();
                ans[top[1]] = i - top[1];
            }
            q.push(new int[]{t, i});
        }
        return ans;
    }
}
