class Solution {
    public int largestRectangleArea(int[] h) {
        Deque<int[]> s = new ArrayDeque<>();
        int[][] lMin = new int[h.length][2], rMin = new int[h.length][2];
        for (int i = 0; i < h.length; i ++) {
            while(!s.isEmpty() && h[i] <= s.peek()[0]) s.pop();
            lMin[i] = s.isEmpty() ? new int[]{-1,-1} : s.peek();
            s.push(new int[]{h[i], i});
        }
        s.clear();
        for (int i = h.length - 1; i >= 0; i --) {
            while(!s.isEmpty() && h[i] <= s.peek()[0]) s.pop();
            rMin[i] = s.isEmpty() ? new int[]{h.length, h.length} : s.peek();
            s.push(new int[]{h[i], i});
        }
        int ans = 0;
        for (int i = 0; i < h.length; i ++) {
            int width = rMin[i][1] - lMin[i][1] - 1;
            ans = Math.max(ans, h[i] * width);
        }
        return ans;
    }
}
