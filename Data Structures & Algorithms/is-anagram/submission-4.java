class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ct = new int[26];
        for (char c : s.toCharArray()) {
            ct[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            ct[c - 'a'] --;
        }
        for (int n : ct)
            if (n != 0) return false;
        return true;
    }
}
