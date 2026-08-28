class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }
        int ans = 0;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (canFinish(piles, h, m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
    private boolean canFinish(int[] piles, int h, int m) {
        int t = 0;
        for (int p : piles) {
            t += p / m;
            t += p % m == 0 ? 0 : 1;
        }
        return t <= h;
    }
}
