public class Problem11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int maxVolume = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxVolume = Math.max(maxVolume, Math.min(height[l], height[r]) * (r - l + 1));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxVolume;
    }
}
