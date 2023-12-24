import java.util.*;

public class Problem15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<List<Integer>, Boolean> triplets = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    if (i != l && i != r) {
                        List<Integer> nn = new ArrayList<>(List.of(nums[i], nums[l], nums[r]));
                        Collections.sort(nn);
                        triplets.put(nn, true);
                    }
                    l++;
                    r--;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> integers : triplets.keySet()) {
            res.add(new ArrayList<>(integers));
        }
        return res;
    }
}
