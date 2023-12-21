import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] arrayForIndices = new int[128];
        Arrays.fill(arrayForIndices, -1);
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arrayForIndices[s.charAt(r)] >= l) {
                l = arrayForIndices[s.charAt(r)] + 1;
            }
            arrayForIndices[s.charAt(r)] = r;
            maxLength = Math.max(maxLength, ++r - l);
        }
        return maxLength;
    }
}
