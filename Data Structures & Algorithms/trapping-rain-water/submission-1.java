class Solution {
    public int trap(int[] h) {
        int[] leftM = new int[h.length];
        int[] rightM = new int[h.length];
        int max = 0;
        for (int i = 1; i < h.length; i ++) {
            max = Math.max(h[i-1], max);
            leftM[i] = max;
        }
        max = 0;
        for (int i = h.length - 2; i >= 0; i --) {
            max = Math.max(h[i+1], max);
            rightM[i] = max;
        }
        int ans = 0;
        for (int i = 1; i < h.length - 1; i ++) {
            int cur = Math.min(leftM[i], rightM[i]) - h[i];
            if (cur > 0) ans += cur;
        }
        return ans;
    }
}
