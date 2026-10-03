class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()
        ans = [0] * (len(nums) - k + 1)
        for i in range(k):
            cur = nums[i]
            while dq and dq[-1][1] <= cur:
                dq.pop()
            dq.append([i, cur])
        ans[0] = dq[0][1]
        for e in range(k, len(nums)):
            s = e - k + 1
            cur = nums[e]
            while dq and dq[-1][1] <= cur:
                dq.pop()
            dq.append([e, cur])
            while dq and dq[0][0] < s:
                dq.popleft()
            ans[s] = dq[0][1]
        return ans