class Solution {
    public String longestPalindrome(String s) {
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);       // 奇数中心
            int len2 = expand(s, i, i + 1);   // 偶数中心
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;     // 由中心和长度反推起点
            }
        }
        return s.substring(start, start + maxLen);
    }   
    // 返回以 (l, r) 为中心能扩出的回文长度
    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return r - l - 1;   // 注意：跳出时 l、r 各多走了一步
    }
}
