import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> ans = new ArrayList<>();
    static ArrayList<Integer> ls = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{7, 8, 4, 3}, 11));
    }

    public static List<List<Integer>> combinationSum(int[] c, int target) {
        helper(c, target, 0);
        return ans;
    }

    public static void helper(int[] c, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = start; i < c.length; i++) {
            if (c[i] <= target) {
                ls.add(c[i]);
                helper(c, target - c[i], i);
                ls.remove(ls.size() - 1);
            }
        }
    }
}