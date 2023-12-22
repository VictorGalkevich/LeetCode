public class Problem1422 {
    public static void main(String[] args) {
        System.out.println(maxScore("1111"));
    }

    public static int maxScore(String s) {
        int[] score = new int[s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0) {
                    score[i] = score[i - 1] + 1;
                } else {
                    score[i]++;
                }
            } else {
                if (i > 0) {
                    score[i] = score[i - 1];
                }
            }
        }
        int[] rScore = new int[s.length() - 1];
        for (int i = s.length() - 1; i > 0 ; i--) {
            if (s.charAt(i) == '1') {
                if (i < s.length() - 1) {
                    rScore[i - 1] = rScore[i] + 1;
                } else {
                    rScore[i - 1]++;
                }
            } else {
                if (i < s.length() - 1) {
                    rScore[i - 1] = rScore[i];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < score.length; i++) {
            if (score[i] + rScore[i] > max) {
                max = score[i] + rScore[i];
            }
        }
        return max;
    }
}
