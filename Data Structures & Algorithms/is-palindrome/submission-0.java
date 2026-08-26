class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] cs = s.toCharArray();
        while (l < r) {
            if (!isAlphanumeric(cs[l])) {l++; continue;}
            if (!isAlphanumeric(cs[r])) {r--; continue;}
            if (Character.toLowerCase(cs[l++]) != Character.toLowerCase(cs[r--])) return false;
        }
        return true;
    }
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }
}
