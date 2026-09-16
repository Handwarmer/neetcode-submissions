class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        memo = {}
        row = len(matrix)
        col = len(matrix[0])
        ans = 1

        dir = [[0,1],[0,-1],[1,0],[-1,0]]

        def dfs(r, c):
            nonlocal ans
            if (r,c) in memo:
                return memo[(r,c)]
            len = 1
            for d in dir:
                nr = r+d[0]
                nc = c+d[1]
                if nr<0 or nr==row or nc<0 or nc==col:
                    continue
                if matrix[nr][nc] <= matrix[r][c]:
                    continue
                len = max(len, 1+dfs(nr, nc))
            ans = max(ans, len)
            memo[(r,c)] = len
            return len

        for r in range(row):
            for c in range(col):
                dfs(r, c)
        return ans