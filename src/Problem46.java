import java.util.ArrayList;
import java.util.List;

public class Problem46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{0, 1, 2}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums);
        return result;
    }

    private static void helper(List<List<Integer>> result, ArrayList<Integer> objects, int[] nums) {
        if (objects.size() == nums.length) {
            result.add(new ArrayList<>(objects));
            return;
        }
        for (int num : nums) {
            if (!objects.contains(num)) {
                objects.add(num);
                helper(result, objects, nums);
                objects.remove(objects.size() - 1);
            }
        }
    }
}
