class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        memo = {}
        # 题目规定边界外可以看作有值为 1 的气球
        # 加上以后，处理边界会简单很多
        nums = [1] + nums + [1]

        """
        dfs(l, r) 表示：
        把原数组下标 l 到 r 之间的气球全部戳破，
        最多能获得多少 coins。

        关键前提：
        nums[l-1] 和 nums[r+1] 作为这个区间外的边界，
        在 dfs(l, r) 处理期间不会被戳破。

        这题不枚举“第一个戳谁”，而是枚举：
        l...r 中“最后一个被戳破”的气球是谁。
        """
        def dfs(l, r):
            if l > r: # 区间为空，没有气球可以戳
                return 0
            if (l,r) in memo: # 这个区间之前已经算过，直接返回
                return memo[(l,r)]
            best = 0
            # 枚举 i：
            # 假设 nums[i] 是区间 l...r 中最后一个被戳破的气球
            for i in range(l, r+1):
                # 如果 i 最后一个被戳，
                # 那么在戳 i 之前：
                #
                # l...i-1 已经全部被戳完
                # i+1...r 已经全部被戳完
                #
                # 所以此时 nums[i] 的左右邻居一定是：
                # nums[l-1] 和 nums[r+1]
                #
                # 因此最后戳 i 的收益是：
                # nums[l-1] * nums[i] * nums[r+1]
                cur = (dfs(l, i-1) # 左边区间能获得的最大收益 
                + nums[l-1] * nums[i] * nums[r+1] # 最后戳 i 的收益
                )+ dfs(i+1, r) # 右边区间能获得的最大收益
                best = max(best, cur) # 尝试每一个 i 作为“最后一个”，取最大值
            # 记住区间 l...r 的最优答案
            memo[(l,r)] = best
            return best

        # 因为 nums 前后各补了一个 1，
        # 真正原数组对应的范围是 1 到 len(nums)-2
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