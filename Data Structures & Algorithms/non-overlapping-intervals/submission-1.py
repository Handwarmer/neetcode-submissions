class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        def overlap(i1, i2):
            return not (i1[0]>=i2[1] or i2[0]>=i1[1])
        
        intervals.sort(key=lambda x: (x[0], x[1]))
        prev = intervals[0]
        ans = 0
        for i, interval in enumerate(intervals):
            if i>0 and overlap(interval, prev):
                ans += 1
                prev = prev if prev[1] < interval[1] else interval
            else:
                prev = interval
        
        return ans
