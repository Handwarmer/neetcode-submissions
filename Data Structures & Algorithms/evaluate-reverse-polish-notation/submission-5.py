class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        dq = deque()
        for t in tokens:
            match t:
                case '+':
                    second = dq.pop()
                    first = dq.pop()
                    dq.append(first + second)
                case '-':
                    second = dq.pop()
                    first = dq.pop()
                    dq.append(first - second)
                case '*':
                    second = dq.pop()
                    first = dq.pop()
                    dq.append(first * second)
                case '/':
                    second = dq.pop()
                    first = dq.pop()
                    dq.append(int(first/second))
                case _:
                    dq.append(int(t))
        return dq.pop()