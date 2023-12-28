import java.util.ArrayList;
import java.util.List;

public class RecursionOfStrings {

    public static void main(String[] args) {
        String string = "abc";
        List<String> result = new ArrayList<>();
        int j = 0;
        generatePermutations(string, 0, string.length()-1, result, j);
        System.out.println(result.toString());
    }

    public static void generatePermutations(String s, int l, int r, List<String> result, int z) {
        if (l == r) {
            result.add(s);
            return;
        }

        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            System.out.println(z++);
            generatePermutations(s, l+1, r, result, z);
            s = swap(s, l, i);
        }
    }

    private static String swap(String s, int a, int b) {
        char[] charArray = s.toCharArray();
        char temp = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = temp;
        return String.valueOf(charArray);
    }
}
