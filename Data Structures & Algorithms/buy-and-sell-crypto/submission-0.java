class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, ans = 0;
        for (int p : prices) {
            ans = Math.max(p - min, ans);
            min = Math.min(min, p);
        }
        return ans;
    }
}
