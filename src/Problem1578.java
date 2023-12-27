import java.util.Arrays;

public class Problem1578 {

    public static void main(String[] args) {
        System.out.println(minCost("abaac", new int[]{1, 2, 3, 4, 5}));
    }
    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return calculateMinCost(n - 1, colors, neededTime, dp, 'A', neededTime[n - 1]);
    }

    private static int calculateMinCost(int i, String colorSequence, int[] timeRequired, int[] memo, char previousColor, int previousTime) {
        if (i < 0) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        if (colorSequence.charAt(i) == previousColor) {
            return memo[i] = calculateMinCost(i - 1, colorSequence, timeRequired, memo, colorSequence.charAt(i), Math.max(timeRequired[i], previousTime)) + Math.min(timeRequired[i], previousTime);
        } else {
            return memo[i] = calculateMinCost(i - 1, colorSequence, timeRequired, memo, colorSequence.charAt(i), timeRequired[i]);
        }
    }
}

