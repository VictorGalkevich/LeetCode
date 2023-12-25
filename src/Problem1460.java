import java.util.Arrays;

class Problem1460 {
    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3}, new int[]{2, 3, 1}));
    }
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}