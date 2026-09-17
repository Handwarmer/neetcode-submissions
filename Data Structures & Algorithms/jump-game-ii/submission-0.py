class Solution:
    # BFS
    def jump(self, nums: List[int]) -> int:
        n = len(nums)

        if n == 1:
            return 0
        
        q = deque([0])
        visited = {0}
        jumps = 0

        while q:
            for _ in range(len(q)):
                i = q.popleft()

                for next in range(i+1, min(n, i + nums[i] + 1)):
                    if next == n - 1:
                        return jumps + 1
                    
                    if next not in visited:
                        visited.add(next)
                        q.append(next)
            
            jumps += 1