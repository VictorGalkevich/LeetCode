public class Problem41 {
    public static void main(String[] args) {
        firstMissingPositive(new int[]{3, 4, -1, 1});
    }
    public static  int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                for (int k = i + 1; k < nums.length; k++) {
                    if (nums[i] < nums[k] || nums[k] < 1) {
                        nums[k] = nums[i];
                    }
                }
                break;
            }
        }
        return 0;
    }
}
