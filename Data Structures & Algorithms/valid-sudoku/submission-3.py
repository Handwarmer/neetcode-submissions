class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [0] * 9
        cols = [0] * 9
        boxes = [0] * 9

        for r in range(9):
            for c in range(9):
                if board[r][c] == '.':
                    continue
                val = ord(board[r][c]) - ord('1')
                if not (rows[r] & (1 << val)) == 0:
                    return False
                else:
                    rows[r] |= 1 << val
                
                if not (cols[c] & (1 << val)) == 0:
                    return False
                else:
                    cols[c] |= 1 << val
                
                b_idx = (r//3)*3 + c//3
                if not (boxes[b_idx] & (1 << val)) == 0:
                    return False
                else:
                    boxes[b_idx] |= 1 << val
                
        return True