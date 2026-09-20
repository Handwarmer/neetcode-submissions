class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        xor = 0
        for i in range(len(nums)+1):
            xor = xor ^ i
        for n in nums:
            xor = xor ^ n
        return xor