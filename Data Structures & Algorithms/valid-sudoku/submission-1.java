class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] sqrs = new int[9];
        for (int r = 0; r < 9; r ++) {
            for (int c = 0; c < 9; c ++) {
                if (board[r][c] == '.') continue;
                int d = board[r][c] - '1';
                int bit = 1 << d;
                if ((rows[r] & bit) != 0) return false;
                rows[r] |= bit;
                if ((cols[c] & bit) != 0) return false;
                cols[c] |= bit;
                int sqri = (r/3)*3 + (c/3);
                if ((sqrs[sqri] & bit) != 0) return false;
                sqrs[sqri] |= bit;
            }
        }
        return true;
    }
}
