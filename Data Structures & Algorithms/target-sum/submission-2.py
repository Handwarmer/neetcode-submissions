class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        # dp[i][s] use first i element, how many ways to sum to s
        # since s can be negative and can't be array index
        # make each dp a dict, so that the 2nd "dimension" can be negative 
        # defaultdict(int) here means for a non-existing key, 
        # default return int(), while int()=0
        dp = [defaultdict(int) for _ in range(n + 1)]
        dp[0][0] = 1

        for i in range(1, n+1):
            cur = nums[i-1]
            for s, ways in dp[i-1].items():
                dp[i][s+cur] += ways
                dp[i][s-cur] += ways 
        
        return dp[n][target]