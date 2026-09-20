class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set()
        for n in nums:
            s.add(n)
        
        ans = 0
        for n in nums:
            if n-1 in s:
                continue
            cur = n
            cur_len = 1
            while (cur+1) in s:
                cur_len += 1
                cur+= 1
            ans = max(ans, cur_len)
        
        return ans