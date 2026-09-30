class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        
        se = set()
        se.add(s[0])

        l = 0
        r = 0
        ans = 1

        while l <= r and r < len(s) - 1:
            r += 1
            while s[r] in se:
                se.remove(s[l])
                l += 1
            se.add(s[r])
            ans = max(ans, r - l + 1)
        
        return ans