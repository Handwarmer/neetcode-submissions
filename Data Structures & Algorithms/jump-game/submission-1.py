class Solution:
    def canJump(self, nums: List[int]) -> bool:
        farthest = 0

        for i in range(len(nums)):
            if i > farthest: #如果最远到不了i，就没戏了
                return False
            #根据从当前i开始能跳多远，来更新最远能到哪
            farthest = max(farthest, i+nums[i])
        return True