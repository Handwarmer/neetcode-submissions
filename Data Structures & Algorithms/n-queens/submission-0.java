class Solution {
    record Point(int r, int c) {}
    List<List<String>> res = new ArrayList<>();
    Set<Integer> diagonal = new HashSet<>();
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
            if (diagonal.contains(r*n + c)) continue;
            cur.add(buildStr(c));
            cols.add(c);
            Set<Integer> diagonalThis = new HashSet<>();
            for (int[] d : dir) {
                int tr = r, tc = c;
                while (tr>=0&&tr<n&&tc>=0&&tc<n) {
                    int diagonalCor = tr*n + tc;
                    if (diagonal.add(diagonalCor)) diagonalThis.add(diagonalCor);
                    tr += d[0]; tc += d[1];
                }
            }
            backtrack(r+1, cur);
            diagonal.removeAll(diagonalThis);
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
