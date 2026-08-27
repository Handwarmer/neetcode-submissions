class Solution {
    public String minWindow(String str, String tar) {
        Map<Character, Integer> cCnt = new HashMap<>();
        int unmatch = 0;
        for (char c : tar.toCharArray()) {
            if (!cCnt.containsKey(c)) {
                unmatch ++;
                cCnt.put(c, -1);
            } else {
                cCnt.put(c, cCnt.get(c)-1);
            }
        }
        int s = 0, e = 0, minLen = Integer.MAX_VALUE, bestS = -1;
        char[] cs = str.toCharArray();
        for (; e < cs.length; e ++) {
            if (!cCnt.containsKey(cs[e])) continue;
            cCnt.put(cs[e], cCnt.get(cs[e]) + 1);
            if (cCnt.get(cs[e]) == 0) unmatch --;
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
                if (cCnt.containsKey(cs[s])) {
                    cCnt.put(cs[s], cCnt.get(cs[s]) - 1);
                    if (cCnt.get(cs[s]) < 0) unmatch ++;
                }
                s ++;
            }
        }
        return bestS == -1 ? "" : str.substring(bestS, bestS + minLen);
    }
}
