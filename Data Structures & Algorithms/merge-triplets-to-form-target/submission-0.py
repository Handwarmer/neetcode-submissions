class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        
        has = [False, False, False]
        for t in triplets:
            canUse = True
            curHas = [False, False, False]
            for i in range(0, 3):
                if t[i] > target[i]:
                    canUse = False
                    break
                elif t[i] == target[i]:
                    curHas[i] = True
            if canUse:
                for i in range(0, 3):
                    has[i] = has[i] or curHas[i]
        
        return has[0] and has[1] and has[2]
        