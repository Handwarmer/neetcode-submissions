class Solution:
    def countBits(self, n: int) -> List[int]:
        def countBit(n):
            ans = 0
            while n:
                n = n & (n-1)
                ans += 1
            return ans
        
        res = []

        for i in range(0, n+1):
            res.append(countBit(i))
        
        return res