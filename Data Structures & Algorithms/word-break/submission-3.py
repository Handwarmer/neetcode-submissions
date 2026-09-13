class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s)+1)
        dp[0] = True
        for i in range(len(s)+1):
            if not dp[i]:
                continue
            for word in wordDict:
                end = i + len(word)
                if end <= len(s) and s.startswith(word, i):
                    dp[end] = True
        return dp[len(s)]