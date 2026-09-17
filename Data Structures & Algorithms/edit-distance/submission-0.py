class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        l1 = len(word1)
        l2 = len(word2)
        memo = {}

        def dfs(i, j):
            if i == l1: # word1走完了，剩下word2没匹配上的部分都要在word1上insert
                return l2 - j
            if j == l2: # word2走完了，剩下word1没匹配上的部分都要在word1上delete
                return l1 - i
            if (i,j) in memo:
                return memo[(i,j)]
            
            if word1[i] == word2[j]:
                ans = dfs(i+1, j+1)
            else:
                ans = 1 + min(
                    dfs(i+1, j), #try delete from word1
                    dfs(i, j+1), #try insert into word1
                    dfs(i+1,j+1) #try replace in word1
                )
            memo[(i,j)] = ans
            return ans
        
        return dfs(0,0)