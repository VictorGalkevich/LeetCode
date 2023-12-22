import java.util.Arrays;

public class Problem5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("caaaaa"));
    }

    //Manacher's Algorithm
    public static String longestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            builder.insert(i + cnt, '$');
            cnt++;
        }
        s = builder.toString();
        int n = s.length();
        int[] d = new int[n];
        Arrays.fill(d, 1);
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i < r) {
                d[i] = Math.min(r - i + 1, d[l + r - i]);
            }
            while (i - d[i] >= 0 && i + d[i] < n && s.charAt(i - d[i]) == s.charAt(i + d[i])) {
                d[i]++;
            }
            if (i + d[i] - 1 > r) {
                l = i - d[i] + 1;
                r = i + d[i] - 1;
            }
        }
        int max = 0;
        int pos = 0;
        for (int i = 0; i < d.length; i++) {
            if ((d[i] > max || (d[i] == max && s.charAt(pos) == '$' && s.charAt(i) != '$')) && !(s.charAt(i) != '$' && d[i] == 2)) {
                max = d[i];
                pos = i;
            }
        }
        StringBuilder res = new StringBuilder(builder.substring(pos - max + 1, pos + max));
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '$') {
                res.deleteCharAt(i);
            }
        }
        return res.toString();
    }
}
