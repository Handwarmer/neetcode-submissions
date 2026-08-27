class Solution {
    public int lengthOfLongestSubstring(String str) {
        int s = 0, e = 0, ans = 0;
        char[] cs = str.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        while (e < cs.length) {
            while (m.containsKey(cs[e])) {
                m.put(cs[s], m.get(cs[s])-1);
                if (m.get(cs[s]) == 0) m.remove(cs[s]);
                s ++;
            }
            ans = Math.max(ans, e - s + 1);
            m.put(cs[e], 1);
            e ++;
        }
        return ans;
    }
}
