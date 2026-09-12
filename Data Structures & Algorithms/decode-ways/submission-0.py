class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0] * (len(s) + 1)
        dp[0] = 1
        if s[0] != '0':
            dp[1] = 1
        else:
            dp[1] = 0
        for i in range(2, len(s)+1):
            one = int(s[i-1])   #最后一位
            two = int(s[i-2:i]) #最后两位
            if one != 0: #最后一位非0才可独立存在
                dp[i] += dp[i-1]
            if two <= 26 and two >= 10: #最后两位，需在10-26之间
                dp[i] += dp[i-2]
        return dp[len(s)]