class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = {}
        for i in range(len(nums)):
            b = target - nums[i]
            if target - nums[i] in m:
                return [m[b], i]
            m[nums[i]] = i
        return []