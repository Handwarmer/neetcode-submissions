class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            j = i + 1
            k = len(nums) - 1
            tar = -nums[i]
            while j < k:
                s = nums[j] + nums[k]
                if s == tar:
                    ans.append([nums[i],nums[j],nums[k]])
                    j += 1
                    k -= 1
                    while j < k and nums[j] == nums[j-1]:
                        j += 1
                elif s < tar:
                    j += 1
                elif s > tar:
                    k -= 1
        return ans