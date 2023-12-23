public class Problem1582 {
    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    public static int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                rowSum += mat[i][j];
                cols[j] += mat[i][j];
            }
            rows[i] = rowSum;
        }
        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
