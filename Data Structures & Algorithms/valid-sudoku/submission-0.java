class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] sqrs = new Set[9];
        for (int r = 0; r < 9; r ++) {
            for (int c = 0; c < 9; c ++) {
                if (board[r][c] == '.') continue;
                if (rows[r] == null) rows[r] = new HashSet<Character>();
                if (!rows[r].add(board[r][c])) return false;
                if (cols[c] == null) cols[c] = new HashSet<Character>();
                if (!cols[c].add(board[r][c])) return false;
                int sqri = (r/3)*3 + (c/3);
                if (sqrs[sqri] == null) sqrs[sqri] = new HashSet<Character>();
                if (!sqrs[sqri].add(board[r][c])) return false;
            }
        }
        return true;
    }
}
