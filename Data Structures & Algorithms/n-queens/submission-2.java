class Solution {
    record Point(int r, int c) {}
    List<List<String>> res = new ArrayList<>();
    // 右上到左下的对角线上，r+c值都相等
    Set<Integer> dia1 = new HashSet<>();
    // 左上到右下的对角线上，r-c值都相等
    Set<Integer> dia2 = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    int[][] dir = new int[][]{{1,1},{-1,1},{1,-1},{-1,-1}};
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        backtrack(0, new ArrayList<>());
        return res;
    }
    void backtrack(int r, List<String> cur) {
        if (cur.size() == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int c = 0; c < n; c ++) {
            if (cols.contains(c)) continue;
            if (dia1.contains(r + c)) continue;
            if (dia2.contains(r - c)) continue;
            cur.add(buildStr(c));
            cols.add(c);
            dia1.add(r+c);
            dia2.add(r-c);
            backtrack(r+1, cur);
            dia1.remove(r+c);
            dia2.remove(r-c);
            cols.remove(c);
            cur.remove(cur.size()-1);
        }
    }
    private String buildStr(int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            if (i == c)
                sb.append('Q');
            else
                sb.append('.');
        }
        return sb.toString();
    }
}
