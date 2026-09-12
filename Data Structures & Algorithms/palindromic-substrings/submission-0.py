class Solution:
    def countSubstrings(self, s: str) -> int:
        ans = 0
        for i in range(0, len(s)):
            ans += self.expand(i, i, s)
            ans += self.expand(i, i + 1, s)
        return ans
    
    def expand(self, l: int, r: int, s: str) -> int:
        count = 0
        while l>=0 and r<len(s) and s[l] == s[r]:
            l -= 1
            r += 1
            count += 1
        return count