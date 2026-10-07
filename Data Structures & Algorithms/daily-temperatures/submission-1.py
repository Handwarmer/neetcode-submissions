class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        dq = deque()
        ans = [0] * len(temperatures)
        for i in range(len(temperatures)):
            t = temperatures[i]
            while dq and dq[-1][1] < t:
                prev = dq.pop()
                ans[prev[0]] = i - prev[0]
            dq.append([i, t])
        return ans