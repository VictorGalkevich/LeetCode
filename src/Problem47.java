import java.util.*;

public class Problem47 {
    static Map<List<Integer>, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] cnt = new int[21];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        helper(result, new ArrayList<>(), nums, cnt);
        return result;
    }

    private static void helper(List<List<Integer>> result, ArrayList<Integer> objects, int[] nums, int[] cnt) {
        if (objects.size() == nums.length) {
            ArrayList<Integer> integers = new ArrayList<>(objects);
            if (map.get(integers) == null) {
                result.add(integers);
                map.put(integers, true);
            }
            return;
        }
        for (int num : nums) {
            if (cnt[num] > 0) {
                objects.add(num);
                int[] cnter = Arrays.copyOf(cnt, cnt.length);
                cnter[num]--;
                helper(result, objects, nums, cnter);
                cnter[num]++;
                objects.remove(objects.size() - 1);
            }
        }
    }
}
