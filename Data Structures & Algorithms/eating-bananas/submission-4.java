class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0, ans = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }
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
    private boolean canFinish(int[] piles, int h, int speed) {
        int t = 0;
        for (int p : piles) {
            t += p/speed;
            if (p % speed != 0)
                t += 1;
        }
        return t <= h;
    }
}
