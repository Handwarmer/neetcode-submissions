class Solution:
    def canJump(self, nums: List[int]) -> bool:
        memo = {}

        def dfs(i):
            if i == len(nums)-1:
                return True
            if nums[i] == 0:
                return False
            if i in memo:
                return memo[i]
            
            ans = False
            for n in range(1, nums[i]+1):
                ans = ans or dfs(i+n)
            
            memo[i] = ans
            return ans
        
        return dfs(0)