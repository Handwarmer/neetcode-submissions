class Solution {
    public int characterReplacement(String str, int k) {
        int s = 0, e = 0, ans = k, len = 0, maxCnt = 0;
        char[] cs = str.toCharArray();
        int[] cCnt = new int[26];
        for (;e < cs.length; e ++) {
            cCnt[cs[e] - 'A'] ++;
            maxCnt = calMaxCnt(cCnt);
            while (e - s + 1 - maxCnt > k) {
                cCnt[cs[s] - 'A'] --;
                s ++;
                maxCnt = calMaxCnt(cCnt);
            }
            ans = Math.max(ans, e - s + 1);
        }
        return ans;
    }
    private int calMaxCnt(int[] cCnt) {
        int res = 0;
        for (int c : cCnt) {
            res = Math.max(res, c);
        }
        return res;
    }
}
