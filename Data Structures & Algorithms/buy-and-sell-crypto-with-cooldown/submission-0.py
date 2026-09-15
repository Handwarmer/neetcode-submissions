class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = [[0]*2 for _ in range(len(prices) + 1)]
        dp[0][1] = -prices[0]
        for i in range(1, len(prices)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp[i][1] = max(dp[i-1][1], 
            (dp[i-2][0] if i > 1 else 0) - prices[i])
        return max(dp[len(prices)-1][0], dp[len(prices)-1][1])