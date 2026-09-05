class Solution {
    List<String> ans = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack(0, 0, new StringBuilder());
        return ans;
    }
    void backtrack(int open, int close, StringBuilder sb) {
        if (close == n) {
            ans.add(sb.toString());
        }
        if (open < n) {
            sb.append("(");
            backtrack(open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
