class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        # dp[i][j] use first i of s, to build first j of t, how many ways
        #
        # first define j, the current length of target
        # then for i in range(1, len(str)), determine whether to use the last char
        # under current range - s[i-1]
        # if not use, then dp[i][j] += dp[i-1][j]
        # if use, the only possible condition is s[i-1] == s[j-1]
        # in this case, dp[i][j] += dp[i-1][j-1]
        ls = len(s)
        lt = len(t)
        dp = [[0]*(lt+1) for _ in range(ls+1)]

        for i in range(ls+1):
            dp[i][0] = 1
        
        for j in range(1, lt+1):
            for i in range(1, ls+1):
                dp[i][j] += dp[i-1][j]
                if s[i-1] == t[j-1]:
                    dp[i][j] += dp[i-1][j-1]
        
        return dp[ls][lt]
                