class Solution:
    def reverse(self, x: int) -> int:
        max = (1<<31) - 1
        min = - (1<<31)
        #python的%和/在负数上跟java不同。
        #比如-123 % 10 = 7，而不是3。
        #-123 // 10 == -13，而不是-12
        #通常的做法是先把符号提出来，运算完再加回去
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