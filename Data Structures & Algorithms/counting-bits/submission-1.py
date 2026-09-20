class Solution:
    def countBits(self, n: int) -> List[int]:
        dp = [0] * (n+1)
        ans = [0]
        for i in range(1, n+1):
            dp[i] = dp[i >> 1] + (1 & i)
            ans.append(dp[i])
        return ans