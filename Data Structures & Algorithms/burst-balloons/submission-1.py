class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        memo = {}
        nums = [1] + nums + [1]

        def dfs(l, r):
            if l > r:
                return 0
            if (l,r) in memo:
                return memo[(l,r)]
            best = 0
            for i in range(l, r+1):
                cur = dfs(l, i-1) + nums[l-1] * nums[i] * nums[r+1] + dfs(i+1, r)
                best = max(best, cur)
            
            memo[(l,r)] = best
            return best

        return dfs(1, len(nums)-2)


    # 普通 dfs + memo, memo大小是O(2^n)
    # def maxCoins(self, nums: List[int]) -> int:
    #     memo = {}

    #     def dfs(balloons):
    #         if balloons in memo:
    #             return memo[balloons]
            
    #         if not balloons:
    #             return 0

    #         best = 0

    #         for i in range(len(balloons)):
    #             l = balloons[i-1] if i>0 else 1
    #             r = balloons[i+1] if i<len(balloons)-1 else 1

    #             coins = balloons[i] * l * r

    #             remaining = balloons[:i] + balloons[i+1:]

    #             best = max(
    #                 best,
    #                 coins + dfs(remaining)
    #                 )

    #         memo[balloons] = best
    #         return best
        
    #     return dfs(tuple(nums))