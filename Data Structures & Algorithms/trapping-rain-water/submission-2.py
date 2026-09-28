class Solution:
    def trap(self, height: List[int]) -> int:
        leftMax = [0] * len(height)
        rightMax = [0] * len(height)
        m = 0
        for i in range(len(height)):
            m = max(m, height[i])
            leftMax[i] = m
        m = 0
        for i in range(len(height)-1, -1, -1):
            m = max(m, height[i])
            rightMax[i] = m
        ans = 0
        for i in range(len(height)):
            ans += min(leftMax[i], rightMax[i]) - height[i]

        return ans