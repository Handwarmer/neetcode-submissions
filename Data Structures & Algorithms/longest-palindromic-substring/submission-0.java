class Solution {
    char[] cs;
    public String longestPalindrome(String s) {
        cs = s.toCharArray();
        int start = 0, maxLen = 0;
        for (int i = 0; i < cs.length; i ++) {
            int len1 = expand(i, i);
            int len2 = expand(i, i+1);
            int curLen = Math.max(len1, len2);
            if (curLen > maxLen) {
                maxLen = curLen;
                start = i - (curLen - 1)/2;
            }
        }
        return s.substring(start, start + maxLen);
    }
    private int expand(int l, int r) {
        while (l>=0 && r < cs.length && cs[l] == cs[r]) {
            l --; r ++;
        }
        return r - l - 1;
    }
}
