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
                #当出现overlap的时候，要删除一个interval。
                #最优解是删除end更大的，保留end更小的那个
                #保留下来的那个作为prev，参与下一次循环的比较
                prev = prev if prev[1] < interval[1] else interval
            else:
                prev = interval
        
        return ans
