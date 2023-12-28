import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) {
        Character[] chars = {'c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l', ' '};
        List<Character> message = new ArrayList<>();
        message.addAll(Arrays.asList(chars));

        System.out.println(reverseWords(message.toArray(new Character[0])));

        reverseWord(message);
        System.out.println(message);
    }

    private static void reverse(List<Character> s, int start, int end) {
        while (start < end) {
            Character temp = s.get(start);
            s.set(start++, s.get(end));
            s.set(end--, temp);
        }
    }

    public static void reverseWord(List<Character> s) {
        int start = 0;
        for (int end = 0; end < s.size(); end++){
            if (s.get(end).equals(' ') && end != 0) {
                reverse(s, start, end-1);
                start = end + 1;
            }
        }

        reverse(s, start, s.size()-1);

        reverse(s, 0, s.size()-1);
    }
    public static String reverseWords(Character[] a) {
        Stack<String> wordStack = new Stack<String>();
        StringBuilder word = new StringBuilder();
        int i = 0;
        for (Character c : a) {
            if (c != ' ') {
                word.append(c);
            } else if (word.length() > 0) {
                wordStack.push(word.toString());
                word = new StringBuilder();
            }
            if ((i == a.length - 1) && word.length() > 0) {
                wordStack.push(word.toString());
            }
            i++;
        }

        word = new StringBuilder();

        if (wordStack.size() > 0) {
            while (!wordStack.empty()) {
                if (wordStack.size() > 1) {
                    word.append(wordStack.pop()).append(' ');
                } else {
                    word.append(wordStack.pop());
                }
            }
        }

        return word.toString();
    }
}
