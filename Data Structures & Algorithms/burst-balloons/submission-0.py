class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        memo = {}

        def dfs(balloons):
            if balloons in memo:
                return memo[balloons]
            
            if not balloons:
                return 0

            best = 0

            for i in range(len(balloons)):
                l = balloons[i-1] if i>0 else 1
                r = balloons[i+1] if i<len(balloons)-1 else 1

                coins = balloons[i] * l * r

                remaining = balloons[:i] + balloons[i+1:]

                best = max(
                    best,
                    coins + dfs(remaining)
                    )

            memo[balloons] = best
            return best
        
        return dfs(tuple(nums))