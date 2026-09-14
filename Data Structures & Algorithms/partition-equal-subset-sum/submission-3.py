class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False
        target = total//2
        # dp[s]表示用目前已经看到过的数字，能不能凑出sum=s
        dp = [False] * (target+1)
        dp[0] = True #一个数字都不用，凑出0没问题

        for num in nums:
            for s in range(target, num - 1, -1):
                dp[s] = dp[s] or dp[s - num]
        
        return dp[target]

    # def canPartition(self, nums: List[int]) -> bool:
    #     total = sum(nums)
    #     if total % 2 != 0:
    #         return False
    #     tar = total/2
    #     memo = {}

    #     # 从i开始，目前已经凑到了cur_sum，最后能不能到target
    #     def dfs(i, cur_sum):
    #         if cur_sum == tar:
    #             return True
    #         if i == len(nums) or cur_sum > tar:
    #             return False
    #         if (i, cur_sum) in memo:
    #             return memo[(i, cur_sum)]
            
    #         take = dfs(i+1, cur_sum + nums[i])
    #         skip = dfs(i+1, cur_sum)
    #         memo[(i, cur_sum)] = take or skip
    #         return memo[(i, cur_sum)]

    #     return dfs(0, 0)
