class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m = defaultdict(list)
        for str in strs:
            count = [0]*26
            for c in str:
                count[ord(c) - ord('a')] += 1
            key = tuple(count)
            m[key].append(str)
        return list(m.values())