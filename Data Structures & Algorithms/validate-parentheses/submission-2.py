class Solution:
    def isValid(self, s: str) -> bool:
        q = deque()
        for c in s:
            match c:
                case '{' | '(' | '[':
                    q.append(c)
                case '}':
                    if not q or q[-1] != '{':
                        return False
                    else:
                        q.pop()
                case ')':
                    if not q or q[-1] != '(':
                        return False
                    else:
                        q.pop()
                case ']':
                    if not q or q[-1] != '[':
                        return False
                    else:
                        q.pop()
        
        return not q