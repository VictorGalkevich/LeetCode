public class Problem4 {
    public static void main(String[] args) {
        int[] a1 = new int[]{1};
        int[] a2 = new int[]{2, 3};
        System.out.println(findMedianSortedArrays(a1, a2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int[] result = merge(nums1, nums2);
        int n = result.length;
        median = n % 2 == 0 ? (double) (result[n / 2] + result[n / 2 + 1]) / 2 : (double) result[n / 2];
        return median;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int lp = 0;
        int rp = 0;
        int[] res = new int[nums1.length + nums2.length];
        int ap = 0;
        int val1 = Integer.MIN_VALUE;
        int val2 = Integer.MIN_VALUE;
        while (lp < nums1.length || rp < nums2.length) {
            if (lp < nums1.length) {
                val1 = nums1[lp];
            } else {
                val1 = Integer.MAX_VALUE;
            }
            if (rp < nums2.length) {
                val2 = nums2[rp];
            } else {
                val2 = Integer.MAX_VALUE;
            }
            if (val1 < val2) {
                res[ap] = val1;
                lp++;
            } else {
                res[ap] = val2;
                rp++;
            }
            ap++;
        }
        return res;
    }
}
