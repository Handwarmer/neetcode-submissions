class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        l1 = len(word1)
        l2 = len(word2)
        # dp[i][j]把word1的前i个变成word2的前j个，最少要多少次操作
        dp = [[0] * (l2+1) for _ in range(l1+1)]

        for j in range(l2+1):
            for i in range(l1+1):
                if j == 0: # word2长度为0的话，就得把word1里的全删了
                    dp[i][j] = i
                    continue
                if i == 0: # word1长度为0的话，就得一直insert到变成word2
                    dp[i][j] = j
                    continue

                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(
                        1+dp[i-1][j], # delete last char of word1
                        1+dp[i-1][j-1], # replace last char of word1
                        1+dp[i][j-1] # insert a new char at end of word1
                    )

        return dp[l1][l2]

    # def minDistance(self, word1: str, word2: str) -> int:
    #     l1 = len(word1)
    #     l2 = len(word2)
    #     memo = {}

    #     def dfs(i, j):
    #         if i == l1: # word1走完了，剩下word2没匹配上的部分都要在word1上insert
    #             return l2 - j
    #         if j == l2: # word2走完了，剩下word1没匹配上的部分都要在word1上delete
    #             return l1 - i
    #         if (i,j) in memo:
    #             return memo[(i,j)]
            
    #         if word1[i] == word2[j]:
    #             ans = dfs(i+1, j+1)
    #         else:
    #             ans = 1 + min(
    #                 dfs(i+1, j), #try delete from word1
    #                 dfs(i, j+1), #try insert into word1
    #                 dfs(i+1,j+1) #try replace in word1
    #             )
    #         memo[(i,j)] = ans
    #         return ans
        
    #     return dfs(0,0)