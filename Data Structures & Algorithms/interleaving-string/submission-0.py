class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False;
        memo = {}

        def dfs(i,j):
            k = i+j
            if k == len(s3):
                return True
            if (i,j) in memo:
                return memo[(i,j)]
            
            b1 = False
            if i < len(s1) and s1[i] == s3[k]:
                b1 = dfs(i+1,j)
            
            b2 = False
            if j < len(s2) and s2[j] == s3[k]:
                b2 = dfs(i, j+1)

            memo[(i,j)] = b1 or b2
            return memo[(i,j)]
        
        return dfs(0,0)