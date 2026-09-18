"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        if not intervals:
            return True
        def conflict(i1, i2):
            return not (i1.start>=i2.end or i2.start>=i1.end)
        intervals.sort(key=lambda x:(x.start,x.end))

        prev=intervals[0]
        for i, interval in enumerate(intervals[1:], start=1):
            if conflict(interval, prev):
                return False
            prev = interval
        
        return True