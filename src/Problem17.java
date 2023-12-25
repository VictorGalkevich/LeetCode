import java.util.ArrayList;
import java.util.List;

public class Problem17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        String[] buttons = {"$", "$", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        solver(res, digits, "", 0, buttons);
        return res;
    }

    public static void solver(List<String> res, String initial, String current, int cnt, String[] buttons) {
        if (cnt == initial.length()) {
            res.add(current);
            return;
        }
        for (int i = 0; i < buttons[initial.charAt(cnt) - '0'].length(); i++) {
            solver(res, initial, current + buttons[initial.charAt(cnt) - '0'].charAt(i), cnt + 1, buttons);
        }
    }
}
