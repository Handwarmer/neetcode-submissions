class Solution:
    def minWindow(self, s: str, t: str) -> str:
        se = {}
        unmatch = 0
        for c in t:
            if not c in se:
                unmatch += 1
                se[c] = - 1
            else:
                se[c] -= 1
        st = 0
        bestS = 0
        minLen = len(s) + 1
        for e in range(len(s)):
            if s[e] in se:
                se[s[e]] += 1
                if se[s[e]] == 0:
                    unmatch -= 1
            while unmatch == 0:
                if e - st + 1 < minLen:
                    minLen = e - st + 1
                    bestS = st
                if s[st] in se:
                    se[s[st]] -= 1
                    if se[s[st]] == -1:
                        unmatch += 1
                st += 1
        
        return "" if minLen == len(s) + 1 else s[bestS:bestS + minLen]



