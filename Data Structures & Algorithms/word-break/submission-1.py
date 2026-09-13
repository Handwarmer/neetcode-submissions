class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s)+1)
        dp[0] = True
        for i in range(len(s)+1):
            for word in wordDict:
                if i - len(word) < 0:
                    continue
                if s[i-len(word):i] == word:
                    dp[i] = dp[i] or dp[i-len(word)]
        return dp[len(s)]