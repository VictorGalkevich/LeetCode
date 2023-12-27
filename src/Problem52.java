class Problem52 {
    private int BOARD_SIZE = 10;
    private int count = 0;

    public int totalNQueens(int n) {
        BOARD_SIZE = n;
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        solveQueens(board, 0);
        return count;
    }

    private void solveQueens(int[][] board, int col) {
        if (col >= BOARD_SIZE) {
            count++;
            return;
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;

                solveQueens(board, col + 1);

                board[row][col] = 0;
            }
        }
    }

    private boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
            if (row + i < BOARD_SIZE && col + i < BOARD_SIZE) {
                if (board[row + i][col + i] == 1) {
                    return false;
                }
            }
            if (row - i >= 0 && col + i < BOARD_SIZE) {
                if (board[row - i][col + i] == 1) {
                    return false;
                }
            }
            if (row + i < BOARD_SIZE && col - i >= 0) {
                if (board[row + i][col - i] == 1) {
                    return false;
                }
            }
            if (row - i >= 0 && col - i >= 0) {
                if (board[row - i][col - i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}