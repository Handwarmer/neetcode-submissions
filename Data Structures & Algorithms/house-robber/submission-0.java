class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //dp[i][0] - 不抢第i个房子
        //dp[i][1] 抢第i个房子
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i ++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][0]+nums[i], dp[i-1][1]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
