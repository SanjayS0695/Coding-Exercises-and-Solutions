import java.util.List;

public class PalindromeString {

    public static void main(String[] args) {
        System.out.println(isPalindrome("hih"));

        var subString = getSubstrings("forgeeksskegforheeehejeehehgeeg", 0, "", 0);
        System.out.println(subString); //eksske
    }

    private static String getSubstrings(String input, int left, String substring, int maxSubLength) {
        if (left >= input.length()) {
            return substring;
        }

        for (int i = left+1; i < input.length(); i++) {
            String sub = input.substring(left, i+1);
            if (isPalindrome(sub) && sub.length() > maxSubLength) {
                substring = sub;
                maxSubLength = sub.length();
            }
        }

        return getSubstrings(input, left+1, substring, maxSubLength);
    }

    private static boolean isPalindrome(String input) {
        char[] arr = input.toCharArray();
        int N = arr.length;
        for (int i = 0; i < N/2; i++) {
            if (arr[i] != arr[N-1-i]) {
                return false;
            }
        }
        return true;
    }
}
