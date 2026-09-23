class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left = []
        product = 1
        for n in nums:
            product *= n
            left.append(product)
        
        right = [0] * len(nums)
        product = 1
        for i in range(len(nums) - 1, -1, -1):
            product *= nums[i]
            right[i] = product
        
        ans = [0] * len(nums)

        for i in range(len(nums)):
            l = 1 if i == 0 else left[i-1]
            r = 1 if i == len(nums)-1 else right[i+1]
            ans[i] = l * r
        
        return ans