public class Problem31 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static void nextPermutation(int[] nums) {
        int pos = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pos = i - 1;
                break;
            }
        }
        int revPoint = -1;
        if (pos == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            for (int i = nums.length - 1; i > -1; i--) {
                if (nums[i] > nums[pos]) {
                    revPoint = i;
                    break;
                }
            }
            swap(nums, pos, revPoint);
            reverse(nums, pos + 1, nums.length - 1);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}
