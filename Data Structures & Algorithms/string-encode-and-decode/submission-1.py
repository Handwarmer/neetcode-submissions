class Solution:

    def encode(self, strs: List[str]) -> str:
        parts = []
        for string in strs:
            parts.append(str(len(string)))
            parts.append('#')
            parts.append(string)
        return "".join(parts)
            
    def decode(self, s: str) -> List[str]:
        i = 0
        res = []
        while i < len(s):
            delimiter_idx = s.find("#", i)
            start = delimiter_idx + 1
            end = delimiter_idx + 1 + int(s[i:delimiter_idx])
            res.append(s[start:end])
            i = end
        return res