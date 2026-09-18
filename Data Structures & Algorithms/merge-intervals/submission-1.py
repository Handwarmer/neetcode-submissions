class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x:x[0])
        ans = [intervals[0]]
        def overlap(i1, i2):
            return not (i1[0]>i2[1] or i2[0]>i1[1])

        for i, interval in enumerate(intervals):
            if i == 0:
                continue
            if overlap(ans[-1], interval):
                ans[-1][0] = min(ans[-1][0], interval[0])
                ans[-1][1] = max(ans[-1][1], interval[1])
            else:
                ans.append(interval)
        
        return ans