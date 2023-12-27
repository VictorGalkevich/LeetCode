import java.util.ArrayList;
import java.util.List;

public class Problem51 {
    private static int BOARD_SIZE = 10;
    private static List<List<String>> result;

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        BOARD_SIZE = n;
        result = new ArrayList<>();
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        solveQueens(board, 0);
        return result;
    }

    private static void solveQueens(int[][] board, int col) {
        if (col >= BOARD_SIZE) {
            save(board);
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

    private static boolean isSafe(int[][] board, int row, int col) {
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

    private static void save(int[][] matrix) {
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (matrix[i][j] == 1) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            arr.add(str.toString());
        }
        result.add(arr);
    }
}
