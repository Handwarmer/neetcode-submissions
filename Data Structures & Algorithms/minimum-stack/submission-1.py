class MinStack:


    
    def __init__(self):
        self.stack = deque()
        self.minQ = deque()

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.minQ.append(val if not self.minQ else min(self.minQ[-1], val))

    def pop(self) -> None:
        self.stack.pop()
        self.minQ.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minQ[-1]
