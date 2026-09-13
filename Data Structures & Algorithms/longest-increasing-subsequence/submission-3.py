class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        memo = {}

        def dfs(i: int) -> int:
            if i in memo:
                return memo[i]
            res = 1
            for j in range(i+1, len(nums)):
                if nums[j] > nums[i]:
                    res = max(res, dfs(j)+1)
            memo[i] = res
            return res
        
        return max(dfs(i) for i in range(len(nums)))