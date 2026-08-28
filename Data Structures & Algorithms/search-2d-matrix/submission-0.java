class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int l = 0, r = row * col - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = matrix[m / col][m % col];
            if (val == target) return true;
            else if (val < target) l = m + 1;
            else if (val > target) r = m - 1;
        }
        return false;
    }
}
