class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] c1Cnt = new int[26], c2Cnt = new int[26];
        for (char c : s1.toCharArray()) {
            c1Cnt[c-'a'] ++;
        }
        int s = 0, e = 0;
        char[] cs = s2.toCharArray();
        for (;e < cs.length; e ++) {
            c2Cnt[cs[e] - 'a'] ++;
            if (e - s + 1 == s1.length()) {
                if (cntMatch(c1Cnt, c2Cnt)) return true;
                c2Cnt[cs[s] - 'a'] --;
                s ++;
            }
        }
        return false;
    }
    private boolean cntMatch(int[] c1Cnt, int[] c2Cnt) {
        for (int i = 0; i < c1Cnt.length; i ++) {
            if (c1Cnt[i] != c2Cnt[i]) return false;
        }
        return true;
    }
}
