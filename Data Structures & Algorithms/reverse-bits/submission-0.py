class Solution:
    def reverseBits(self, n: int) -> int:
        ans = 0

        for i in range(0, 32):
            bit = n & 1
            ans = (ans << 1) + bit
            n = n >> 1
        
        return ans