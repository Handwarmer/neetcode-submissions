class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_idx = {}
        for i, char in enumerate(s):
            last_idx[char] = i
        
        cur_max = 0
        start = 0
        ans = []
        for i, char in enumerate(s):
            if i <= cur_max:
                cur_max = max(cur_max, last_idx[char])
            else:
                ans.append(cur_max - start + 1)
                start = cur_max + 1
                cur_max = last_idx[char]
        
        ans.append(cur_max - start + 1)

        return ans