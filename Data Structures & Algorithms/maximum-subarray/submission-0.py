class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        ans = float('-inf')
        curSum = float('-inf')
        for i in range(len(nums)):
            curSum += nums[i]
            if (curSum < nums[i]):
                curSum = nums[i]
            ans = max(ans, curSum)
        return ans