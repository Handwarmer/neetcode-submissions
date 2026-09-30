class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        ans = 1
        l = 0
        r = 0
        freq = [0] * 26
        def calc_max_freq():
            mf = 0
            for f in freq:
                mf = max(mf, f)
            return mf

        max_freq = 0
        for r in range(len(s)):
            freq[ord(s[r]) - ord('A')] += 1
            max_freq = calc_max_freq()

            while r - l + 1 - max_freq > k:
                freq[ord(s[l]) - ord('A')] -= 1
                max_freq = calc_max_freq()
                l += 1
            ans = max(ans, r - l + 1)

        return ans