class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        l1 = len(s1)
        l2 = len(s2)
        l3 = len(s3)
        if l1 + l2 != l3:
            return False
        # dp[i][j]: s1 的前 i 个字符 + s2 的前 j 个字符，
        # 能不能 interleave 成 s3 的前 i+j 个字符
        dp = [[False] * (l2+1) for _ in range(l1+1)]

        dp[0][0] = True

        for i in range(l1+1):
            for j in range(l2+1):
                if i > 0:
                    dp[i][j] = dp[i][j] or (dp[i-1][j] and (s1[i-1] == s3[i+j-1]))
                if j > 0:
                    dp[i][j] = dp[i][j] or (dp[i][j-1] and (s2[j-1] == s3[i+j-1]))
        
        return dp[l1][l2]

    # def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
    #     if len(s1) + len(s2) != len(s3):
    #         return False;
    #     memo = {}

    #     def dfs(i,j):
    #         k = i+j
    #         if k == len(s3):
    #             return True
    #         if (i,j) in memo:
    #             return memo[(i,j)]
            
    #         b1 = False
    #         if i < len(s1) and s1[i] == s3[k]:
    #             b1 = dfs(i+1,j)
            
    #         b2 = False
    #         if j < len(s2) and s2[j] == s3[k]:
    #             b2 = dfs(i, j+1)

    #         memo[(i,j)] = b1 or b2
    #         return memo[(i,j)]
        
    #     return dfs(0,0)