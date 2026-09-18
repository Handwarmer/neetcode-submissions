class Solution:
    def checkValidString(self, s: str) -> bool:
        left_stack = deque()
        star_stack = deque()
        for i, c in enumerate(s):
            if c == '(':
                left_stack.append((i, c))
            elif c == '*':
                star_stack.append((i, c))
            else: # right ')', attempt to pop
                if left_stack:
                    left_stack.pop()
                elif star_stack:
                    star_stack.pop()
                else:
                    return False
        
        while left_stack:
            if not star_stack:
                return False
            left_i, left = left_stack.pop()
            star_i, star = star_stack.pop()
            if left_i > star_i:
                return False
        
        return True