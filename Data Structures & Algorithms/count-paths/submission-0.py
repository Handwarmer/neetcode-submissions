class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = {}
        
        # 从r,c出发到bottom-right有多少种路径
        def dfs(r, c):
            if r==m or c==n:
                return 0
            if r == m-1 and c == n-1:
                return 1
            if (r,c) in memo:
                return memo[(r,c)]
            res = dfs(r+1,c) + dfs(r, c+1)
            memo[(r,c)] = res
            return res

        return dfs(0,0)