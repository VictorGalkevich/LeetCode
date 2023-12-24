import java.util.*;

import static java.lang.Math.abs;

public class Problem16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp > target) {
                    int currDiff = abs(tmp - target);
                    if (currDiff < minDiff) {
                        if (i != l && i != r) {
                            minDiff = currDiff;
                            closest = tmp;
                        }
                    }
                    r--;
                } else if (tmp < target) {
                    int currDiff = abs(target - tmp);
                    if (currDiff < minDiff) {
                        if (i != l && i != r) {
                            minDiff = currDiff;
                            closest = tmp;
                        }
                    }
                    l++;
                } else {
                    if (i != l && i != r) {
                        return tmp;
                    }
                    l++;
                    r--;
                }
            }
        }
        return closest;
    }
}
