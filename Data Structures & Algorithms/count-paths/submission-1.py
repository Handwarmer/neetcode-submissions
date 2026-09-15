class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0]*(n+1) for _ in range(m+1)]
        dp[0][0] = 1
        for r in range(m+1):
            for c in range(n+1):
                if r > 0:
                    dp[r][c] += dp[r-1][c]
                if c > 0:
                    dp[r][c] += dp[r][c-1]
        
        return dp[m-1][n-1]

    # def uniquePaths(self, m: int, n: int) -> int:
    #     memo = {}
        
    #     # 从r,c出发到bottom-right有多少种路径
    #     def dfs(r, c):
    #         if r==m or c==n:
    #             return 0
    #         if r == m-1 and c == n-1:
    #             return 1
    #         if (r,c) in memo:
    #             return memo[(r,c)]
    #         res = dfs(r+1,c) + dfs(r, c+1)
    #         memo[(r,c)] = res
    #         return res

    #     return dfs(0,0)