class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        row = len(matrix)
        col = len(matrix[0])
        cells = []
        # 如果用dp[r][c]代表从[r,c]出发的最长path的话，就必须要dp[r][c] depend on的dp[x][y]先被计算好，也就是[r,c]上/下/左/右的邻居[x,y]
        # 并且这里matrix[x][y]必须比matrix[r][c]大，否则[r,c]是走不到[x,y]的
        # 因此，如果想让[x][y]先计算好的话，就要按matrix里的值从大到小算
        # 所以第一步，把matrix所有的格子挨个从大到小排序
        for r in range(row):
            for c in range(col):
                cells.append((matrix[r][c], r, c))
        
        cells.sort(key=lambda x:x[0], reverse=True)

        dir = [[-1,0],[1,0],[0,1],[0,-1]]
        dp = [[1] * col for _ in range(row)]
        ans = 1

        for v, r, c in cells:
            for d in dir:
                nr = r+d[0]
                nc = c+d[1]
                if nr<0 or nr == row or nc<0 or nc==col:
                    continue
                if matrix[nr][nc] <= matrix[r][c]:
                    continue
                dp[r][c] = max(dp[r][c], dp[nr][nc]+1)
                ans = max(ans, dp[r][c])
        
        return ans

    # def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
    #     memo = {}
    #     row = len(matrix)
    #     col = len(matrix[0])
    #     ans = 1

    #     dir = [[0,1],[0,-1],[1,0],[-1,0]]

    #     def dfs(r, c):
    #         nonlocal ans
    #         if (r,c) in memo:
    #             return memo[(r,c)]
    #         len = 1
    #         for d in dir:
    #             nr = r+d[0]
    #             nc = c+d[1]
    #             if nr<0 or nr==row or nc<0 or nc==col:
    #                 continue
    #             if matrix[nr][nc] <= matrix[r][c]:
    #                 continue
    #             len = max(len, 1+dfs(nr, nc))
    #         ans = max(ans, len)
    #         memo[(r,c)] = len
    #         return len

    #     for r in range(row):
    #         for c in range(col):
    #             dfs(r, c)
    #     return ans