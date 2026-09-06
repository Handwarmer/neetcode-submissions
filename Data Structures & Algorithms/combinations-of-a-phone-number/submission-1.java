class Solution {
    List<String> ans = new ArrayList<>();
    char[] cs;
    char[][] map = new char[][]{
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}
    };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        cs = digits.toCharArray();
        backtrack(0, new StringBuilder());
        return ans;
    }
    void backtrack(int i, StringBuilder sb) {
        if (i == cs.length) {
            ans.add(sb.toString());
            return;
        }
        int digitIdx = cs[i] - '2';
        for (char c : map[digitIdx]) {
            sb.append(c);
            backtrack(i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
