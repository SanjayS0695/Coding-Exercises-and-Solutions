import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseVowelsOfString {

    public static void main(String[] args) {
        String string = "aA";
        System.out.println(reverseVowels(string));
    }

    public static String reverseVowels(String s) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

        Stack<Character> chars = new Stack<Character>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i<sb.length();i++) {
            if (vowels.contains(Character.toLowerCase(sb.charAt(i)))) {
                chars.push(s.charAt(i));
            }
        }

        for (int i = 0; i<s.length();i++) {
            if (vowels.contains(Character.toLowerCase(sb.charAt(i))))) {
                sb.setCharAt(i, chars.pop());
            }
        }

        return sb.toString();
    }
}
