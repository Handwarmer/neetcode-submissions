class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False
        target = total//2
        # dp[i][s]表示用前i个数能否凑出s
        dp = [[False] * (target+1) for _ in range(len(nums)+1)]
        dp[0][0] = True
        
        for i in range(1, len(nums)):
            dp[i][0] = True
            num = nums[i]
            for s in range(num, target+1):
                dp[i][s] = dp[i-1][s-num] or dp[i-1][s]

        return dp[len(nums)-1][target]

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
