class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        cur_min = nums[0]
        cur_max = nums[0]
        res = nums[0]
        for n in nums[1:]:
            prev_min = cur_min
            prev_max = cur_max
            cur_min = min(prev_min*n, n, prev_max*n)
            cur_max = max(prev_min*n, n, prev_max*n)
            res = max(res, cur_max)
        return res
