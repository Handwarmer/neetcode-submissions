class Solution:
    def hammingWeight(self, n: int) -> int:
        mask = 1
        ans = 0
        while n > 0:
            ans += mask & n
            n = n >> 1
        return ans