class Solution:
    def reverse(self, x: int) -> int:
        max = (1<<31) - 1
        min = - (1<<31)
        sign = -1 if x < 0 else 1
        x = abs(x)
        res = 0
        while x:
            digit = x%10
            res = res*10 + digit
            if res > max:
                return 0
            x = x//10
        return res * sign