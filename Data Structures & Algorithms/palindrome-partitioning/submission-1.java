class Solution {
    List<List<String>> ans = new ArrayList<>();
    String s;
    char[] cs;
    public List<List<String>> partition(String s) {
        this.s = s;
        cs = s.toCharArray();
        backtrack(0, new ArrayList<>());
        return ans;
    }
    void backtrack(int start, List<String> cur) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int end = start; end < s.length(); end ++) {
            if (isPalindrome(start, end)) {
                cur.add(s.substring(start, end+1));
                backtrack(end+1, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    private boolean isPalindrome(int start, int end) {
        int i = start, j = end;
        while (i <= j) {
            if (cs[i] != cs[j]) return false;
            i++;j--;
        }
        return true;
    }
}
