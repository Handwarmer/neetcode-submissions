class Solution:
    # 简化版BFS，省掉queue，用l,r记录当前层对应的范围
    def jump(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return 0
        
        l = 1
        r = nums[0]
        step = 1

        while True:
            if r >= len(nums) - 1:
                return step
            nextL = r+1
            nextR = r+1
            for i in range(l, r+1):
                nextR = max(nextR, i+nums[i])
            l = nextL
            r = nextR
            step += 1

    # BFS
    # def jump(self, nums: List[int]) -> int:
    #     n = len(nums)

    #     if n == 1:
    #         return 0
        
    #     q = deque([0])
    #     visited = {0}
    #     jumps = 0

    #     while q:
    #         for _ in range(len(q)):
    #             i = q.popleft()

    #             for next in range(i+1, min(n, i + nums[i] + 1)):
    #                 if next == n - 1:
    #                     return jumps + 1
                    
    #                 if next not in visited:
    #                     visited.add(next)
    #                     q.append(next)
            
    #         jumps += 1