class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0] * (amount+1) for _ in range(len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0] = 1
        
        for s in range(amount+1):
            for i in range(1, len(coins)+1):
                dp[i][s] = dp[i-1][s]
                coin = coins[i-1]
                if s - coin >= 0:
                    dp[i][s] += dp[i][s-coin]
        
        return dp[len(coins)][amount]