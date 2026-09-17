class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        memo = {}

        def dfs(i, j):
            # pattern 用完
            # 只有 s 也用完才成功
            # 反过来如果pattern没用完倒是无所谓。比如a*b*可以匹配空字符串
            if j == len(p):
                return i == len(s)
            if (i,j) in memo:
                return memo[(i,j)]
            # 当前字符是否 match
            # 注意 s 可能已经用完，所以先检查 i
            match = (
                i < len(s)
                and (s[i] == p[j] or p[j] == '.')
            )
            # 先判断当前是不是 x*
            if j < len(p) - 1 and p[j + 1] == '*':

                # x* 有两个选择：
                #
                # 1. 用 0 次：
                #    s 不动，跳过整个 x*
                #
                # 2. 用 >= 1 次：
                #    前提是当前字符 match
                #    吃掉一个 s 字符
                #    pattern 仍停在 x*，因为还可以继续吃
                res = (
                    dfs(i, j + 2)
                    or
                    (match and dfs(i + 1, j))
                )

            else:
                # 没有 *
                # 当前字符必须 match
                res = match and dfs(i + 1, j + 1)

            memo[(i, j)] = res
            return res
        
        return dfs(0,0)