"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        ans = 0
        start_end = []
        for interval in intervals:
            start_end.append([interval.start, 0])
            start_end.append([interval.end, 1])
        
        # 时间相同时，把end排在前面
        start_end.sort(key=lambda x:(x[0],-x[1]))

        cur = 0
        for se in start_end:
            if se[1] == 0:
                cur += 1
                ans = max(ans, cur)
            else:
                cur -= 1
        
        return ans