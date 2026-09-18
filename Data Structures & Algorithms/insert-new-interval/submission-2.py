class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        def overlap(i1, i2):
            return not (i1[0]>i2[1] or i1[1]<i2[0])
        def merge(i1, i2):
            return [min(i1[0],i2[0]), max(i1[1],i2[1])]
        ans = []
        inserted = False
        for i, interval in enumerate(intervals):
            if interval[1] < newInterval[0]:
                ans.append(interval)
            elif interval[0] > newInterval[1]:
                if not inserted:
                    ans.append(newInterval)
                    inserted = True
                ans.append(interval)
            else:
                newInterval = merge(interval, newInterval)
        
        if not inserted:
            ans.append(newInterval)
        
        return ans