import java.util.Map;

public class MclarenSV {


    private static Map<Character, Integer> romanIntMap = Map.of('I', 1, 'V', 5,
            'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);


    public static void main(String[] args) {
       System.out.println(convertToInt("LVIII"));
    }

    private static Integer convertToInt(String input) {
        if (input.length() == 0) {
            return null;
        }
        char[] arr = input.toCharArray();

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = romanIntMap.get(arr[i]);
            if (i+1 < arr.length) {
                int next = romanIntMap.get(arr[i + 1]);
                if (current >= next) {
                    result += current;
                } else {
                    result -= current;
                }
            } else {
                result += current;
            }
        }
        return result;
    }
}
