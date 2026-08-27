class Solution {
    public String minWindow(String str, String tar) {
        int[] cCnt = new int[128];
        boolean[] inTar = new boolean[128];       // 代替 containsKey
        int unmatch = 0;
        for (char c : tar.toCharArray()) {
            if (!inTar[c]) {
                inTar[c] = true;
                unmatch ++;
                cCnt[c] = -1;
            } else {
                cCnt[c] = cCnt[c] - 1;
            }
        }
        int s = 0, e = 0, minLen = Integer.MAX_VALUE, bestS = -1;
        char[] cs = str.toCharArray();
        for (; e < cs.length; e ++) {
            if (!inTar[cs[e]]) continue;
            cCnt[cs[e]] = cCnt[cs[e]] + 1;
            if (cCnt[cs[e]] == 0) unmatch --;
            if (unmatch == 0) {
                if (e - s + 1 < minLen) {
                    minLen = e - s + 1;
                    bestS = s;
                }
            }
            while (unmatch == 0) {
                if (e - s + 1 < minLen) {
                    minLen = e - s + 1;
                    bestS = s;
                }
                if (inTar[cs[s]]) {
                    cCnt[cs[s]] = cCnt[cs[s]] - 1;
                    if (cCnt[cs[s]] < 0) unmatch ++;
                }
                s ++;
            }
        }
        return bestS == -1 ? "" : str.substring(bestS, bestS + minLen);
    }
}